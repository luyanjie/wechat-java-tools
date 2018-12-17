package com.xinba.wechat.api;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jokin
 * @date 2018/12/17 14:25
 * 默认消息重复检查器.
 * 将每个消息id保存在内存里，每隔5秒清理已经过期的消息id，每个消息id的过期时间是15秒
 */
public class WxMessageInMemoryDuplicateChecker implements WxMessageDuplicateChecker {

    /**
     * 一个消息ID在内存的过期时间：15秒
     */
    private final Long timeToLive;

    /**
     * 每隔多少周期检查消息ID是否过期：5秒
     */
    private final Long clearPeriod;

    /**
     * 消息id->消息时间戳的map.
     */
    private final ConcurrentHashMap<String, Long> msgId2Timestamp = new ConcurrentHashMap<>();

    /**
     * 后台清理线程是否已经开启.
     */
    private final AtomicBoolean backgroundProcessStarted = new AtomicBoolean(false);


    /**
     * 无参构造方法.
     * <pre>
     * 一个消息ID在内存的过期时间：15秒
     * 每隔多少周期检查消息ID是否过期：5秒
     * </pre>
     */
    public WxMessageInMemoryDuplicateChecker() {
        this.timeToLive = 15 * 1000L;
        this.clearPeriod = 5 * 1000L;
    }

    /**
     * 构造方法.
     *
     * @param timeToLive  一个消息ID在内存的过期时间：毫秒
     * @param clearPeriod 每隔多少周期检查消息ID是否过期：毫秒
     */
    public WxMessageInMemoryDuplicateChecker(Long timeToLive, Long clearPeriod) {
        this.timeToLive = timeToLive;
        this.clearPeriod = clearPeriod;
    }

    protected void checkBackgroundProcessStarted() {
        if (this.backgroundProcessStarted.getAndSet(true)) {
            return;
        }

        ExecutorService service = Executors.newSingleThreadExecutor(r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            // 设置为守护线程
            t.setDaemon(true);
            return t;
        });

        service.execute(() -> {
            try {
                while (true) {
                    // 间隔指定的时间周期轮询
                    Thread.sleep(WxMessageInMemoryDuplicateChecker.this.clearPeriod);
                    Long now = System.currentTimeMillis();
                    for (Map.Entry<String, Long> entry :
                            WxMessageInMemoryDuplicateChecker.this.msgId2Timestamp.entrySet()) {
                        // 操作设定的过期时间，直接剔除
                        if (now - entry.getValue() > WxMessageInMemoryDuplicateChecker.this.timeToLive) {
                            WxMessageInMemoryDuplicateChecker.this.msgId2Timestamp.entrySet().remove(entry);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 判断消息是否重复.
     * <h2>公众号的排重方式</h2>
     *
     * <p>普通消息：关于重试的消息排重，推荐使用msgid排重。<a href="http://mp.weixin.qq.com/wiki/10/79502792eef98d6e0c6e1739da387346.html">文档参考</a>。</p>
     * <p>事件消息：关于重试的消息排重，推荐使用FromUserName + CreateTime 排重。<a href="http://mp.weixin.qq.com/wiki/2/5baf56ce4947d35003b86a9805634b1e.html">文档参考</a></p>
     *
     * <h2>企业号的排重方式</h2>
     * <p>官方文档完全没有写，参照公众号的方式排重。</p>
     * <p>或者可以采取更简单的方式，如果有MsgId就用MsgId排重，如果没有就用FromUserName+CreateTime排重</p>
     *
     * @param messageId messageId需要根据上面讲的方式构造
     * @return 如果是重复消息，返回true，否则返回false
     */
    @Override
    public boolean isDuplicate(String messageId) {
        if (StringUtils.isAllEmpty(messageId)) {
            return false;
        }
        checkBackgroundProcessStarted();
        // 如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
        Long timestamp = this.msgId2Timestamp.putIfAbsent(messageId, System.currentTimeMillis());
        return timestamp != null;
    }
}
