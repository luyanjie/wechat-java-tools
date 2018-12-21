package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceQrCodeResult extends AbstractDeviceBean {
    private static final long serialVersionUID = -4312858303060918266L;

    @JSONField(name = "deviceid")
    private String deviceId;
    @JSONField(name = "qrticket")
    private String qrTicket;
    @JSONField(name = "devicelicence")
    private String deviceLicence;
    @JSONField(name = "base_resp")
    private BaseResponse baseResp;

    public static WxDeviceQrCodeResult fromJson(String json) {
        return fromJson(json, WxDeviceQrCodeResult.class);
    }

}
