package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:44
 *
 * 卡券二维码返回信息
 */
@Data
public class WxMpCardQrcodeCreateResult implements Serializable {
    private static final long serialVersionUID = 766748631465287739L;
    private Integer errcode;
    private String errmsg;
    private String ticket;

    @JSONField(name = "expire_seconds")
    private Integer expireSeconds;

    private String url;

    @JSONField(name = "show_qrcode_url")
    private String showQrcodeUrl;

    public boolean isSuccess() {
        return 0 == errcode;
    }

    public static WxMpCardQrcodeCreateResult fromJson(String json) {
        return JSON.parseObject(json, WxMpCardQrcodeCreateResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
