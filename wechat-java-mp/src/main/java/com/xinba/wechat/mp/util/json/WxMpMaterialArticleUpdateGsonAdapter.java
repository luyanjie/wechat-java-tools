package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialArticleUpdate;

import java.lang.reflect.Type;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialArticleUpdateGsonAdapter implements JsonSerializer<WxMpMaterialArticleUpdate> {

  @Override
  public JSONObject serialize(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate, Type typeOfSrc) {
    JSONObject articleUpdateJson = new JSONObject();
    articleUpdateJson.put("media_id", wxMpMaterialArticleUpdate.getMediaId());
    articleUpdateJson.put("index", wxMpMaterialArticleUpdate.getIndex());
    articleUpdateJson.put("articles", wxMpMaterialArticleUpdate.getArticles());
    return articleUpdateJson;
  }

}
