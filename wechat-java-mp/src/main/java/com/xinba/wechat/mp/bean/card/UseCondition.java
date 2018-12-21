package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:39
 *
 * 使用门槛
 */
@Data
public class UseCondition implements Serializable {

    private static final long serialVersionUID = 374837763435339276L;
    /**
     * 指定可用的商品类目,仅用于代金券类型 ，填入后将在券面拼写适用于xxx
     */
    @JSONField(name = "accept_category")
    private String acceptCategory;

    /**
     * 指定不可用的商品类目,仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
     */
    @JSONField(name = "reject_category")
    private String rejectCategory;

    /**
     * 满减门槛字段,可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用
     */
    @JSONField(name = "least_cost")
    private Integer leastCost;

    /**
     * 购买xx可用类型门槛,仅用于兑换 ，填入后自动拼写购买xxx可用
     */
    @JSONField(name = "object_use_for")
    private String objectUseFor;

    /**
     * 不可以与其他类型共享门槛,填写false时系统将在使用须知里 拼写“不可与其他优惠共享”， 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true
     */
    @JSONField(name = "can_use_with_other_discount")
    private boolean canUseWithOtherDiscount;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

