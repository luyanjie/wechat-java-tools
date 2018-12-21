package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:28
 *
 * 会员开卡返回
 */
@Data
public class MemberCardActivateUserFormResult implements Serializable {
    private static final long serialVersionUID = 7346284218073447434L;
    private Integer errcode;
    private String errmsg;

    public boolean isSuccess() {
        return 0 == errcode;
    }

    public static MemberCardActivateUserFormResult fromJson(String json) {
        return JSON.parseObject(json, MemberCardActivateUserFormResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}