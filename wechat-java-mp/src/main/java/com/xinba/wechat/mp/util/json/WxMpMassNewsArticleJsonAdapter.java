package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.WxMpMassNews;
import org.apache.commons.lang3.BooleanUtils;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:42
 */
public class WxMpMassNewsArticleJsonAdapter  implements JsonSerializer<WxMpMassNews.WxMpMassNewsArticle>, JsonDeserializer<WxMpMassNews.WxMpMassNewsArticle> {
    @Override
    public WxMpMassNews.WxMpMassNewsArticle deserialize(JSONObject json, Type type) {
        WxMpMassNews.WxMpMassNewsArticle article = new WxMpMassNews.WxMpMassNewsArticle();

        Object title = json.get("title");
        if (title != null) {
            article.setTitle(title.toString());
        }
        Object content = json.get("content");
        if (content != null) {
            article.setContent(content.toString());
        }
        Object contentSourceUrl = json.get("content_source_url");
        if (contentSourceUrl != null) {
            article.setContentSourceUrl(contentSourceUrl.toString());
        }
        Object author = json.get("author");
        if (author != null) {
            article.setAuthor(author.toString());
        }
        Object digest = json.get("digest");
        if (digest != null) {
            article.setDigest(digest.toString());
        }
        Object thumbMediaId = json.get("thumb_media_id");
        if (thumbMediaId != null) {
            article.setThumbMediaId(thumbMediaId.toString());
        }
        Object showCoverPic = json.get("show_cover_pic");
        if (showCoverPic != null) {
            article.setShowCoverPic(json.getBoolean("show_cover_pic"));
        }
        return article;
    }

    @Override
    public JSONObject serialize(WxMpMassNews.WxMpMassNewsArticle article, Type var2) {
        JSONObject articleJson = new JSONObject();

        articleJson.put("thumb_media_id", article.getThumbMediaId());
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
        return articleJson;
    }
}
