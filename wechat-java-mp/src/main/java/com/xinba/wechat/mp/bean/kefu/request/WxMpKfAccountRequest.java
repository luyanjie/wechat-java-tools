package com.xinba.wechat.mp.bean.kefu.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 * */
@Data
@Builder
@AllArgsConstructor
public class WxMpKfAccountRequest extends AbstractKefuBean implements Serializable {
    private static final long serialVersionUID = -5451863610674856927L;
    /**
     * kf_account.
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @JSONField(name = "kf_account")
    private String kfAccount;
    /**
     * nickname.
     * 客服昵称，最长6个汉字或12个英文字符
     */
    @JSONField(name = "nickname")
    private String nickName;
    /**
     * invite_wx.
     * 接收绑定邀请的客服微信号
     */
    @JSONField(name = "invite_wx")
    private String inviteWx;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public String toJson() {
        return super.toJson();
    }

}
