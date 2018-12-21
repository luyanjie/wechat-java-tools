package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem;

import java.lang.reflect.Type;
import java.util.Date;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialFileBatchGetGsonItemAdapter implements JsonDeserializer<WxMaterialFileBatchGetNewsItem> {

  @Override
  public WxMaterialFileBatchGetNewsItem deserialize(JSONObject json, Type type){
    WxMaterialFileBatchGetNewsItem newsItem = new WxMaterialFileBatchGetNewsItem();
;
    if (json.get("media_id") != null ) {
      newsItem.setMediaId(json.getString("media_id"));
    }
    if (json.get("update_time") != null ) {
      newsItem.setUpdateTime(new Date(1000 * json.getLong("update_time")));
    }
    if (json.get("name") != null ) {
      newsItem.setName(json.getString("name"));
    }
    if (json.get("url") != null ) {
      newsItem.setUrl(json.getString("url"));
    }
    return newsItem;
  }
}
