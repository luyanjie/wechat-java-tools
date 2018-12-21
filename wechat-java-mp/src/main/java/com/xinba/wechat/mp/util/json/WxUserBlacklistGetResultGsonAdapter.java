package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpUserBlacklistGetResult;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxUserBlacklistGetResultGsonAdapter implements JsonDeserializer<WxMpUserBlacklistGetResult> {
    @Override
    public WxMpUserBlacklistGetResult deserialize(JSONObject json, Type type) {
        WxMpUserBlacklistGetResult wxMpUserBlacklistGetResult = new WxMpUserBlacklistGetResult();
        wxMpUserBlacklistGetResult.setTotal(json.getInteger("total"));
        wxMpUserBlacklistGetResult.setCount(json.getInteger("count"));
        wxMpUserBlacklistGetResult.setNextOpenid(json.getString("next_openid"));
        if (json.get("data") != null && json.getJSONObject("data").get("openid") != null) {
            JSONArray data = json.getJSONObject("data").getJSONArray("openid");
            for (int i = 0; i < data.size(); i++) {
                wxMpUserBlacklistGetResult.getOpenidList().add(data.getString(i));
            }
        }
        return wxMpUserBlacklistGetResult;
    }
}
