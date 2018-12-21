package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialNewsGsonAdapter implements JsonSerializer<WxMpMaterialNews>, JsonDeserializer<WxMpMaterialNews> {

  @Override
  public JSONObject serialize(WxMpMaterialNews wxMpMaterialNews, Type type) {
    JSONObject newsJson = new JSONObject();

    JSONArray articleJsonArray = new JSONArray();
    for (WxMpMaterialNews.WxMpMaterialNewsArticle article : wxMpMaterialNews.getArticles()) {
      articleJsonArray.add(article);
    }
    newsJson.put("articles", articleJsonArray);

    if (wxMpMaterialNews.getCreatedTime() != null) {
      newsJson.put("create_time",
        SimpleDateFormat.getDateTimeInstance().format(wxMpMaterialNews.getCreatedTime()));
    }

    if (wxMpMaterialNews.getUpdatedTime() != null) {
      newsJson.put("update_time",
        SimpleDateFormat.getDateTimeInstance().format(wxMpMaterialNews.getUpdatedTime()));
    }

    return newsJson;
  }

  @Override
  public WxMpMaterialNews deserialize(JSONObject json, Type type) {
    WxMpMaterialNews wxMpMaterialNews = new WxMpMaterialNews();

    if (json.get("news_item") != null) {
      JSONArray articles = json.getJSONArray("news_item");

      articles.forEach(x->{
        JSONObject o = (JSONObject)x;
        wxMpMaterialNews.addArticle(JSON.parseObject(o.toJSONString(),WxMpMaterialNews.WxMpMaterialNewsArticle.class));
      });

    }

    if (json.get("create_time") != null) {
      Date createTime = new Date(json.getLong("create_time")* 1000);
      wxMpMaterialNews.setCreatedTime(createTime);
    }

    if (json.get("update_time") != null) {
      Date updateTime = new Date(json.getLong("update_time")* 1000);
      wxMpMaterialNews.setUpdatedTime(updateTime);
    }

    return wxMpMaterialNews;
  }
}
