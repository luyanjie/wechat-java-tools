package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018-12-18
 */
@Data
public class WxMpShakeAroundPageAddResult implements Serializable {
    private Integer errorCode;
    private String errorMsg;
    private Integer pageId;

    public static WxMpShakeAroundPageAddResult fromJson(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        WxMpShakeAroundPageAddResult result = new WxMpShakeAroundPageAddResult();
        result.setErrorCode(jsonObject.getInteger("errcode"));
        result.setErrorMsg(jsonObject.getString("errmsg"));
        jsonObject = jsonObject.getJSONObject("data");
        if (jsonObject != null) {
            result.setPageId(jsonObject.getInteger("page_id"));
        }
        return result;
    }
}
