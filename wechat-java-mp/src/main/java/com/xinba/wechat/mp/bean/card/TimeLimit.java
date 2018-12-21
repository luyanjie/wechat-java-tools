package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:38
 *
 * 使用字段时限设置
 */
@Data
public class TimeLimit implements Serializable {

    /**
     * 限制类型枚举值,支持填入 MONDAY 周一 TUESDAY 周二 WEDNESDAY 周三 THURSDAY 周四 FRIDAY 周五 SATURDAY 周六 SUNDAY 周日 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
     */
    private String type;

    /**
     * 起始时间（小时）,当前type类型下的起始时间（小时） ，如当前结构体内填写了MONDAY， 此处填写了10，则此处表示周一 10:00可用
     */
    @JSONField(name = "begin_hour")
    private Integer beginHour;

    /**
     * 起始时间（分钟）,如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59可用
     */
    @JSONField(name = "begin_minute")
    private Integer beginMinute;

    /**
     * 结束时间（小时）,如当前结构体内填写了MONDAY， 此处填写了20， 则此处表示周一 10:00-20:00可用
     */
    @JSONField(name = "end_hour")
    private Integer endHour;

    /**
     * 结束时间（分钟）,如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59-00:59可用
     */
    @JSONField(name = "end_minute")
    private Integer endMinute;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
