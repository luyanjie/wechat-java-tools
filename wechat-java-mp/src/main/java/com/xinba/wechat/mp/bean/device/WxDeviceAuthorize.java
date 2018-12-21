package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceAuthorize extends AbstractDeviceBean {
    private static final long serialVersionUID = 8786321356569903887L;

    @JSONField(name ="device_num")
    private String deviceNum;
    @JSONField(name ="op_type")
    private String opType;
    @JSONField(name ="product_id")
    private String productId;
    @JSONField(name ="device_list")
    private List<WxDevice> deviceList = new LinkedList<>();

    public void addDevice(WxDevice... devices) {
        this.deviceList.addAll(Arrays.asList(devices));
    }
}