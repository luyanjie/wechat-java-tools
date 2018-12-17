package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import com.xinba.wechat.common.api.WxConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:15
 * <p>
 * 按标签群发的消息
 */
@Data
public class WxMpMassTagMessage implements Serializable {
    private static final long serialVersionUID = -5812502733318586999L;
    /**
     * 标签ID，如果不设置就意味着发送给所有人
     */
    private Long tagId;

    /**
     * <pre>
     * 消息类型
     * 请使用
     * {@link WxConstant.MassMsgType#IMAGE}
     * {@link WxConstant.MassMsgType#MPNEWS}
     * {@link WxConstant.MassMsgType#TEXT}
     * {@link WxConstant.MassMsgType#MPVIDEO}
     * {@link WxConstant.MassMsgType#VOICE}
     * 如果msgtype和media_id不匹配的话，会返回系统繁忙的错误
     * </pre>
     */
    private String msgType;
    private String content;
    private String mediaId;
    /**
     * 是否群发给所有人
     */
    private boolean isSendAll = false;
    /**
     * 文章被判定为转载时，是否继续进行群发操作。
     */
    private boolean sendIgnoreReprint = false;

    /**
     * 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    private String clientMsgId;

    public String toJosn() {
        return JSON.toJSONString(this);
    }

    public void setSendAll(boolean sendAll) {
        if (sendAll) {
            setTagId(null);
        }
        setSendAll(sendAll);
    }
}
