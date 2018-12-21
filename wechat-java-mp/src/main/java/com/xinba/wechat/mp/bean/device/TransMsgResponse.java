package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TransMsgResponse extends AbstractDeviceBean {

    private static final long serialVersionUID = 9091013201002004222L;
    private Integer ret;
    @JSONField(name = "ret_info")
    private String retInfo;
    @JSONField(name = "errcode")
    private Integer errCode;
    @JSONField(name = "errmsg")
    private String errMsg;

    public static TransMsgResponse fromJson(String json) {
        return fromJson(json, TransMsgResponse.class);
    }
}