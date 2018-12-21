package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:50
 *
 * 设备绑定返回
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceBindResult extends AbstractDeviceBean {

    private static final long serialVersionUID = 7050369165514072766L;
    @JSONField(name = "base_resp")
    private BaseResponse baseResp;

    public static WxDeviceBindResult fromJson(String json) {
        return fromJson(json, WxDeviceBindResult.class);
    }
}