package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:45
 *
 * 设备信息
 */
@Data
public class WxDevice implements Serializable {

    private static final long serialVersionUID = 1210497076127360506L;
    private String id;
    private String mac;
    @JSONField(name = "connect_protocol")
    private String connectProtocol;
    @JSONField(name = "auth_key")
    private String authKey;
    @JSONField(name = "close_strategy")
    private String closeStrategy;
    @JSONField(name = "conn_strategy")
    private String connStrategy;
    @JSONField(name = "crypt_method")
    private String cryptMethod;
    @JSONField(name = "auth_ver")
    private String authVer;
    @JSONField(name = "manu_mac_pos")
    private String manuMacPos;
    @JSONField(name = "ser_mac_pos")
    private String serMacPos;
    @JSONField(name = "ble_simple_protocol")
    private String bleSimpleProtocol;
}
