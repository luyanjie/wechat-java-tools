package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseResponse extends AbstractDeviceBean {
    private static final long serialVersionUID = 4252655933699659073L;

    @JSONField(name = "base_info")
    private BaseInfo baseInfo;
    @JSONField(name = "errcode")
    private Integer errCode;
    @JSONField(name = "errmsg")
    private String errMsg;

    @Data
    private class BaseInfo {
        @JSONField(name = "device_type")
        private String deviceType;

        @JSONField(name = "device_id")
        private String deviceId;
    }
}