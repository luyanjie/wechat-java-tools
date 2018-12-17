package com.xinba.wechat.mp.bean;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 17:40
 *
 * 微信卡券
 */
@Data
public class WxMpCard implements Serializable{
    private static final long serialVersionUID = -1541782611763236883L;

    /**
     * 卡券号
     * */
    private String cardId;

    /**
     * 开始时间
     * */
    private Long beginTime;

    /**
     * 结束时间
     * */
    private Long endTime;

    /**
     * 状态
     * */
    private String userCardStatus;

    /**
     * 是否可被消耗
     * */
    private Boolean canConsume;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
