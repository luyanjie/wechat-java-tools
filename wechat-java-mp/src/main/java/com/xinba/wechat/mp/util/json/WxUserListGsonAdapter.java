package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpUserList;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxUserListGsonAdapter implements JsonDeserializer<WxMpUserList> {

    @Override
    public WxMpUserList deserialize(JSONObject json, Type type) {
        WxMpUserList wxMpUserList = new WxMpUserList();
        wxMpUserList.setTotal(json.getLong("total"));
        wxMpUserList.setCount(json.getInteger("count"));
        wxMpUserList.setNextOpenid(json.getString("next_openid"));
        if (json.get("data") != null && json.getJSONObject("data").get("openid") != null) {
            JSONArray data = json.getJSONObject("data").getJSONArray("openid");
            for (int i = 0; i < data.size(); i++) {
                wxMpUserList.getOpenids().add(data.getString(i));
            }
        }
        return wxMpUserList;
    }

}
