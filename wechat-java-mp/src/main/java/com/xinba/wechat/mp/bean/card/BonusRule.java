package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:16
 *
 * 积分规则
 */
@Data
public class BonusRule implements Serializable {
    /**
     * 消费金额,以分为单位。
     */
    @JSONField(name = "cost_money_unit")
    private Integer costMoneyUnit;

    /**
     * 对应增加的积分
     */
    @JSONField(name = "increase_bonus")
    private Integer increaseBonus;

    /**
     * 用户单次可获取的积分上限
     */
    @JSONField(name = "max_increase_bonus")
    private Integer maxIncreaseBonus;

    /**
     * 初始设置积分
     */
    @JSONField(name = "init_increase_bonus")
    private Integer initIncreaseBonus;

    /**
     * 每使用积分
     */
    @JSONField(name = "cost_bonus_unit")
    private Integer costBonusUnit;

    /**
     * 抵扣xx元,这里以分为单位）
     */
    @JSONField(name = "reduce_money")
    private Integer reduceMoney;

    /**
     * 抵扣条件,满xx元（这里以分为单位）可用。
     */
    @JSONField(name = "least_moneyto_use_bonus")
    private Integer leastMoneytoUseBonus;

    /**
     * 抵扣条件,单笔最多使用xx积分。
     */
    @JSONField(name = "max_reduce_bonus")
    private Integer maxReduceBonus;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
