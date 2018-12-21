package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpMassSendResult;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 17:10
 */
public class WxMpMassSendResultAdapter implements JsonDeserializer<WxMpMassSendResult> {
    @Override
    public WxMpMassSendResult deserialize(JSONObject json, Type type) {
        WxMpMassSendResult sendResult = new WxMpMassSendResult();

        if (json.get("errcode") != null ) {
            sendResult.setErrorCode(json.getString("errcode"));
        }
        if (json.get("errmsg") != null ) {
            sendResult.setErrorMsg(json.getString(("errmsg")));
        }
        if (json.get("msg_id") != null ) {
            sendResult.setMsgId(json.getString(("msg_id")));
        }
        if (json.get("msg_data_id") != null ) {
            sendResult.setMsgDataId(json.getString(("msg_data_id")));
        }
        return sendResult;
    }
}
