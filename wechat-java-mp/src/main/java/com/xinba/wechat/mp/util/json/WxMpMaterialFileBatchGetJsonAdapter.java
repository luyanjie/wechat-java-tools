package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialFileBatchGetResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialFileBatchGetJsonAdapter implements JsonDeserializer<WxMpMaterialFileBatchGetResult> {

  @Override
  public WxMpMaterialFileBatchGetResult deserialize(JSONObject json, Type type) {
    WxMpMaterialFileBatchGetResult wxMpMaterialFileBatchGetResult = new WxMpMaterialFileBatchGetResult();
    if (json.get("total_count") != null ) {
      wxMpMaterialFileBatchGetResult.setTotalCount(json.getInteger("total_count"));
    }
    if (json.get("item_count") != null ) {
      wxMpMaterialFileBatchGetResult.setItemCount(json.getInteger("item_count"));
    }
    if (json.get("item") != null) {
      JSONArray array = json.getJSONArray("item");
      List<WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem> items = new ArrayList<>();
      array.forEach(x->{
        JSONObject o = (JSONObject)x;
        items.add(JSON.parseObject(o.toJSONString(),WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem.class));
      });
      wxMpMaterialFileBatchGetResult.setItems(items);
    }
    return wxMpMaterialFileBatchGetResult;
  }
}
