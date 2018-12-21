package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 10:46
 *
 * 图文分析数据接口返回结果对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxDataCubeArticleResult extends WxDataCubeBaseResult {
    private static final long serialVersionUID = -9222452497954511765L;

    /**
     * ref_hour
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    @JSONField(name = "ref_hour")
    private Integer refHour;

    /**
     * msgid
     * 请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）
     * 和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，
     * 假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    @JSONField(name = "msgid")
    private String msgId;

    /**
     * title
     * 图文消息的标题
     */
    @JSONField(name = "title")
    private String title;

    /**
     * int_page_read_user
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    @JSONField(name = "int_page_read_user")
    private Integer intPageReadUser;

    /**
     * int_page_read_count
     * 图文页的阅读次数
     */
    @JSONField(name = "int_page_read_count")
    private Integer intPageReadCount;

    /**
     * ori_page_read_user
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    @JSONField(name = "ori_page_read_user")
    private Integer oriPageReadUser;

    /**
     * ori_page_read_count
     * 原文页的阅读次数
     */
    @JSONField(name = "ori_page_read_count")
    private Integer oriPageReadCount;

    /**
     * share_scene
     * 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     */
    @JSONField(name = "share_scene")
    private Integer shareScene;

    /**
     * share_user
     * 分享的人数
     */
    @JSONField(name = "share_user")
    private Integer shareUser;

    /**
     * share_count
     * 分享的次数
     */
    @JSONField(name = "share_count")
    private Integer shareCount;

    /**
     * add_to_fav_user
     * 收藏的人数
     */
    @JSONField(name = "add_to_fav_user")
    private Integer addToFavUser;

    /**
     * add_to_fav_count
     * 收藏的次数
     */
    @JSONField(name = "add_to_fav_count")
    private Integer addToFavCount;

    /**
     * user_source
     * 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他
     */
    @JSONField(name = "user_source")
    private Integer userSource;

    public static List<WxDataCubeArticleResult> fromJson(String json) {

        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),
                new TypeReference<List<WxDataCubeArticleResult>>(){});
    }
}
