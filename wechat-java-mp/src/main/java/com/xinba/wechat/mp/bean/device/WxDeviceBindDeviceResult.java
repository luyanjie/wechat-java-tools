package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:48
 *
 * 返回绑定设备
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceBindDeviceResult extends AbstractDeviceBean {
    private static final long serialVersionUID = 725870295905935355L;

    @JSONField(name = "resp_msg")
    private ResponseMsg respMsg;
    @JSONField(name = "openid")
    private String openId;
    @JSONField(name = "device_list")
    private List<Device> devices;

    public static WxDeviceBindDeviceResult fromJson(String json) {
        return fromJson(json, WxDeviceBindDeviceResult.class);
    }

    @Data
    private class Device {
        @JSONField(name = "device_type")
        private String deviceType;
        @JSONField(name = "device_id")
        private String deviceId;
    }
}