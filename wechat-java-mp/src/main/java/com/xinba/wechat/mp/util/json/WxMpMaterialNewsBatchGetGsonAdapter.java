package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNewsBatchGetResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialNewsBatchGetGsonAdapter implements JsonDeserializer<WxMpMaterialNewsBatchGetResult> {

    @Override
    public WxMpMaterialNewsBatchGetResult deserialize(JSONObject json, Type type) {
        WxMpMaterialNewsBatchGetResult wxMpMaterialNewsBatchGetResult = new WxMpMaterialNewsBatchGetResult();

        if (json.get("total_count") != null) {
            wxMpMaterialNewsBatchGetResult.setTotalCount(json.getInteger("total_count"));
        }
        if (json.get("item_count") != null) {
            wxMpMaterialNewsBatchGetResult.setItemCount(json.getInteger("item_count"));
        }
        if (json.get("item") != null) {
            JSONArray array = json.getJSONArray("item");
            List<WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem> items = new ArrayList<>();

            array.forEach(x -> {
                JSONObject o = (JSONObject) x;
                items.add(JSON.parseObject(o.toJSONString(), WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem.class));
            });

            wxMpMaterialNewsBatchGetResult.setItems(items);
        }
        return wxMpMaterialNewsBatchGetResult;
    }
}
