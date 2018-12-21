package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpMassUploadResult;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 17:14
 */
public class WxMpMassUploadResultAdapter implements JsonDeserializer<WxMpMassUploadResult> {

    @Override
    public WxMpMassUploadResult deserialize(JSONObject json, Type type) {
        WxMpMassUploadResult uploadResult = new WxMpMassUploadResult();

        if (json.get("type") != null) {
            uploadResult.setType(json.getString("type"));
        }
        if (json.get("media_id") != null) {
            uploadResult.setMediaId(json.getString("media_id"));
        }
        if (json.get("created_at") != null) {
            uploadResult.setCreatedAt(json.getLong("created_at"));
        }
        return uploadResult;
    }
}
