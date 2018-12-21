package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.WxMpMassVideo;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 17:16
 */
public class WxMpMassVideoAdapter implements JsonSerializer<WxMpMassVideo>{
    @Override
    public JSONObject serialize(WxMpMassVideo message, Type var2) {
        JSONObject messageJson = new JSONObject();
        messageJson.put("media_id", message.getMediaId());
        messageJson.put("description", message.getDescription());
        messageJson.put("title", message.getTitle());
        return messageJson;
    }
}
