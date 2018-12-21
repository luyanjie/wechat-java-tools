package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:47
 * <p>
 * 绑定设备
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceBind extends AbstractDeviceBean {
    private static final long serialVersionUID = 467559769037590880L;

    private String ticket;
    @JSONField(name = "device_id")
    private String deviceId;
    @JSONField(name = "openid")
    private String openId;

}
