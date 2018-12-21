package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.WxMpMassNews;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:47
 */
public class WxMpMassNewsJsonAdapter implements JsonSerializer<WxMpMassNews>, JsonDeserializer<WxMpMassNews> {
    @Override
    public WxMpMassNews deserialize(JSONObject json, Type type) {
        WxMpMassNews wxMpMassNews = new WxMpMassNews();
        if (json.get("media_id") != null) {
            JSONArray articles = json.getJSONArray("articles");

            articles.forEach(x->{
                JSONObject o = (JSONObject)x;
                WxMpMassNews.WxMpMassNewsArticle article = JSON.parseObject(o.toJSONString(), WxMpMassNews.WxMpMassNewsArticle.class);
                wxMpMassNews.addArticle(article);
            });
        }
        return wxMpMassNews;
    }

    @Override
    public JSONObject serialize(WxMpMassNews message, Type var2) {
        JSONObject newsJson = new JSONObject();
        JSONArray articleJsonArray = new JSONArray();
        articleJsonArray.addAll(message.getArticles());
        newsJson.put("articles", articleJsonArray);
        return newsJson;
    }
}
