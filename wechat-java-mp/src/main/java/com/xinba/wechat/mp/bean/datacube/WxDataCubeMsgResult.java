package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:27
 *
 * 消息分析数据接口返回结果对象.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxDataCubeMsgResult extends WxDataCubeBaseResult {
    private static final long serialVersionUID = 6932121822150573659L;

    /**
     * ref_hour.
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    @JSONField(name = "ref_hour")
    private Integer refHour;

    /**
     * msg_type.
     * 消息类型，代表含义如下：1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
     */
    @JSONField(name = "msg_type")
    private Integer msgType;

    /**
     * msg_user.
     * 上行发送了（向公众号发送了）消息的用户数
     */
    @JSONField(name = "msg_user")
    private Integer msgUser;

    /**
     * msg_count.
     * 上行发送了消息的消息总数
     */
    @JSONField(name = "msg_count")
    private Integer msgCount;

    /**
     * count_interval.
     * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
     */
    @JSONField(name = "count_interval")
    private Integer countInterval;

    /**
     * int_page_read_count
     * 图文页的阅读次数
     */
    @JSONField(name = "int_page_read_count")
    private Integer intPageReadCount;

    /**
     * ori_page_read_user.
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    @JSONField(name = "ori_page_read_user")
    private Integer oriPageReadUser;

    public static List<WxDataCubeMsgResult> fromJson(String json) {
        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),
                new TypeReference<List<WxDataCubeMsgResult>>(){});
    }
}