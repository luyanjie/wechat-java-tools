package com.xinba.wechat.mp.util.json;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem;

import java.lang.reflect.Type;
import java.util.Date;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialNewsBatchGetGsonItemAdapter implements JsonDeserializer<WxMaterialNewsBatchGetNewsItem> {

  @Override
  public WxMaterialNewsBatchGetNewsItem deserialize(JSONObject json, Type type) {
    WxMaterialNewsBatchGetNewsItem wxMaterialNewsBatchGetNewsItem = new WxMaterialNewsBatchGetNewsItem();

    if (json.get("media_id") != null ) {
      wxMaterialNewsBatchGetNewsItem.setMediaId(json.getString("media_id"));
    }
    if (json.get("update_time") != null ) {
      wxMaterialNewsBatchGetNewsItem.setUpdateTime(new Date(1000 * json.getLong("update_time")));
    }
    if (json.get("content") != null ) {
      wxMaterialNewsBatchGetNewsItem.setContent(JSON.parseObject(json.getString("content"), WxMpMaterialNews.class));
    }
    return wxMaterialNewsBatchGetNewsItem;
  }
}
