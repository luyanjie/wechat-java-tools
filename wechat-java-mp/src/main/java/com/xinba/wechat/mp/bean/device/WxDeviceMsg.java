package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author jokin
 * @date 2018/12/18 11:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceMsg extends AbstractDeviceBean {

    private static final long serialVersionUID = 5461570846588974648L;
    @JSONField(name = "device_type")
    private String deviceType;
    @JSONField(name = "device_id")
    private String deviceId;
    @JSONField(name = "open_id")
    private String openId;
    private String content;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}