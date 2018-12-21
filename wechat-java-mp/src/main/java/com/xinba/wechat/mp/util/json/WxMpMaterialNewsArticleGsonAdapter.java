package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews.WxMpMaterialNewsArticle;
import org.apache.commons.lang3.BooleanUtils;

import java.lang.reflect.Type;

/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialNewsArticleGsonAdapter implements JsonSerializer<WxMpMaterialNewsArticle>, JsonDeserializer<WxMpMaterialNewsArticle> {

  @Override
  public JSONObject serialize(WxMpMaterialNewsArticle article, Type type) {
    JSONObject articleJson = new JSONObject();

    articleJson.put("thumb_media_id", article.getThumbMediaId());
    articleJson.put("thumb_url", article.getThumbUrl());
    articleJson.put("title", article.getTitle());
    articleJson.put("content", article.getContent());
    if (null != article.getAuthor()) {
      articleJson.put("author", article.getAuthor());
    }
    if (null != article.getContentSourceUrl()) {
      articleJson.put("content_source_url", article.getContentSourceUrl());
    }
    if (null != article.getDigest()) {
      articleJson.put("digest", article.getDigest());
    }
    articleJson.put("show_cover_pic", article.isShowCoverPic() ? "1" : "0");
    if (null != article.getUrl()) {
      articleJson.put("url", article.getUrl());
    }

    if (null != article.getNeedOpenComment()) {
      articleJson.put("need_open_comment",
        BooleanUtils.toInteger(article.getNeedOpenComment(), 1, 0));
    }

    if (null != article.getOnlyFansCanComment()) {
      articleJson.put("only_fans_can_comment",
        BooleanUtils.toInteger(article.getOnlyFansCanComment(), 1, 0));
    }
    return articleJson;
  }

  @Override
  public WxMpMaterialNewsArticle deserialize(JSONObject json, Type type) {
    WxMpMaterialNewsArticle article = new WxMpMaterialNewsArticle();

    Object title = json.get("title");
    if (title != null) {
      article.setTitle(json.getString("title"));
    }
    Object content = json.get("content");
    if (content != null) {
      article.setContent(json.getString("content"));
    }
    Object contentSourceUrl = json.get("content_source_url");
    if (contentSourceUrl != null) {
      article.setContentSourceUrl(json.getString("content_source_url"));
    }
    Object author = json.get("author");
    if (author != null) {
      article.setAuthor(json.getString("author"));
    }
    Object digest = json.get("digest");
    if (digest != null ) {
      article.setDigest(json.getString("digest"));
    }
    Object thumbMediaId = json.get("thumb_media_id");
    if (thumbMediaId != null) {
      article.setThumbMediaId(json.getString("thumb_media_id"));
    }
    Object thumbUrl = json.get("thumb_url");
    if (thumbUrl != null ) {
      article.setThumbUrl(json.getString("thumb_url"));
    }
    Object showCoverPic = json.get("show_cover_pic");
    if (showCoverPic != null) {
      article.setShowCoverPic(BooleanUtils.toBoolean(json.getInteger("show_cover_pic")));
    }
    Object url = json.get("url");
    if (url != null ) {
      article.setUrl(json.getString("url"));
    }

    Object needOpenComment = json.get("need_open_comment");
    if (needOpenComment != null) {
      article.setNeedOpenComment(BooleanUtils.toBoolean(json.getInteger("need_open_comment")));
    }

    Object onlyFansCanComment = json.get("only_fans_can_comment");
    if (onlyFansCanComment != null ) {
      article.setOnlyFansCanComment(BooleanUtils.toBoolean(json.getInteger("need_open_comment")));
    }
    return article;
  }
}
