package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseMsg extends AbstractDeviceBean {
    private static final long serialVersionUID = -4241272701707684136L;

    @JSONField(name = "ret_code")
    private Integer retCode;
    @JSONField(name = "error_info")
    private String errorInfo;
}
