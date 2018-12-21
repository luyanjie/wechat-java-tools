package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:30
 *
 * 建卡请求信息
 */
@Data
public class MemberCardCreateRequest implements Serializable {

    private static final long serialVersionUID = -4288513607129602088L;
    @JSONField(name = "card_type")
    private String cardType = "MEMBER_CARD";

    @JSONField(name = "member_card")
    private MemberCard memberCard;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
