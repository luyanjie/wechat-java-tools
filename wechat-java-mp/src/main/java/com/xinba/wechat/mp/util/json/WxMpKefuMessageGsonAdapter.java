package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.mp.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:37
 */
public class WxMpKefuMessageGsonAdapter implements JsonSerializer<WxMpKefuMessage>{
    @Override
    public JSONObject serialize(WxMpKefuMessage message, Type var2) {
        JSONObject messageJson = new JSONObject();
        messageJson.put("touser", message.getToUser());
        messageJson.put("msgtype", message.getMsgType());

        if (WxConstant.KefuMsgType.TEXT.equals(message.getMsgType())) {
            JSONObject text = new JSONObject();
            text.put("content", message.getContent());
            messageJson.put("text", text);
        }

        if (WxConstant.KefuMsgType.IMAGE.equals(message.getMsgType())) {
            JSONObject image = new JSONObject();
            image.put("media_id", message.getMediaId());
            messageJson.put("image", image);
        }

        if (WxConstant.KefuMsgType.VOICE.equals(message.getMsgType())) {
            JSONObject voice = new JSONObject();
            voice.put("media_id", message.getMediaId());
            messageJson.put("voice", voice);
        }

        if (WxConstant.KefuMsgType.VIDEO.equals(message.getMsgType())) {
            JSONObject video = new JSONObject();
            video.put("media_id", message.getMediaId());
            video.put("thumb_media_id", message.getThumbMediaId());
            video.put("title", message.getTitle());
            video.put("description", message.getDescription());
            messageJson.put("video", video);
        }

        if (WxConstant.KefuMsgType.MUSIC.equals(message.getMsgType())) {
            JSONObject music = new JSONObject();
            music.put("title", message.getTitle());
            music.put("description", message.getDescription());
            music.put("thumb_media_id", message.getThumbMediaId());
            music.put("musicurl", message.getMusicUrl());
            music.put("hqmusicurl", message.getHqMusicUrl());
            messageJson.put("music", music);
        }

        if (WxConstant.KefuMsgType.NEWS.equals(message.getMsgType())) {
            JSONObject news = new JSONObject();
            JSONArray articleJsonArray = new JSONArray();
            for (WxMpKefuMessage.WxArticle article : message.getArticles()) {
                JSONObject articleJson = new JSONObject();
                articleJson.put("title", article.getTitle());
                articleJson.put("description", article.getDescription());
                articleJson.put("url", article.getUrl());
                articleJson.put("picurl", article.getPicUrl());
                articleJsonArray.add(articleJson);
            }
            news.put("articles", articleJsonArray);
            messageJson.put("news", news);
        }

        if (WxConstant.KefuMsgType.MPNEWS.equals(message.getMsgType())) {
            JSONObject json = new JSONObject();
            json.put("media_id", message.getMpNewsMediaId());
            messageJson.put("mpnews", json);
        }

        if (WxConstant.KefuMsgType.WXCARD.equals(message.getMsgType())) {
            JSONObject wxcard = new JSONObject();
            wxcard.put("card_id", message.getCardId());
            messageJson.put("wxcard", wxcard);
        }

        if (WxConstant.KefuMsgType.MINIPROGRAMPAGE.equals(message.getMsgType())) {
            JSONObject miniProgramPage = new JSONObject();
            miniProgramPage.put("title", message.getTitle());
            miniProgramPage.put("appid", message.getMiniProgramAppId());
            miniProgramPage.put("pagepath", message.getMiniProgramPagePath());
            miniProgramPage.put("thumb_media_id", message.getThumbMediaId());
            messageJson.put("miniprogrampage", miniProgramPage);
        }

        if (StringUtils.isNotBlank(message.getKfAccount())) {
            JSONObject newsJsonObject = new JSONObject();
            newsJsonObject.put("kf_account", message.getKfAccount());
            messageJson.put("customservice", newsJsonObject);
        }

        return messageJson;
    }
}
