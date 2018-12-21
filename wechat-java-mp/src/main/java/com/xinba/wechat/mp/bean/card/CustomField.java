package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:19
 *
 * 自定义会员信息类目对象
 */
@Data
public class CustomField implements Serializable {

    private static final long serialVersionUID = -1481340879338766667L;
    /**
     * 半自定义名称,当开发者变更这类类目信息的value值时 可以选择触发系统模板消息通知用户。 FIELD_NAME_TYPE_LEVEL 等级 FIELD_NAME_TYPE_COUPON 优惠券 FIELD_NAME_TYPE_STAMP 印花 FIELD_NAME_TYPE_DISCOUNT 折扣 FIELD_NAME_TYPE_ACHIEVEMEN 成就 FIELD_NAME_TYPE_MILEAGE 里程 FIELD_NAME_TYPE_SET_POINTS 集点 FIELD_NAME_TYPE_TIMS 次数
     */
    @JSONField(name = "name_type")
    private String nameType;

    /**
     * 自定义名称,当开发者变更这类类目信息的value值时 不会触发系统模板消息通知用户
     */
    private String name;

    /**
     * 点击类目跳转外链url
     */
    private String url;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
