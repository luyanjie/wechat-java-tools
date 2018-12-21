package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceOpenIdResult extends AbstractDeviceBean {

    private static final long serialVersionUID = -1091886036998399751L;
    @JSONField(name = "errcode")
    private Integer errCode;
    @JSONField(name = "errmsg")
    private String errMsg;
    @JSONField(name = "open_id")
    private List<String> openIds;
    @JSONField(name = "resp_msg")
    private ResponseMsg respMsg;

    public static WxDeviceOpenIdResult fromJson(String json) {
        return fromJson(json, WxDeviceOpenIdResult.class);
    }

}
