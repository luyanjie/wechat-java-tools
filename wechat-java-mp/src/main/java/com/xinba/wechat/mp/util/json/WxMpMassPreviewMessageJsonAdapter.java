package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.mp.bean.WxMpMassPreviewMessage;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 17:07
 */
public class WxMpMassPreviewMessageJsonAdapter implements JsonSerializer<WxMpMassPreviewMessage>{
    @Override
    public JSONObject serialize(WxMpMassPreviewMessage wxMpMassPreviewMessage, Type var2) {
        JSONObject json = new JSONObject();
        json.put("towxname", wxMpMassPreviewMessage.getToWxUserName());
        json.put("touser", wxMpMassPreviewMessage.getToWxUserOpenid());
        if (WxConstant.MassMsgType.MPNEWS.equals(wxMpMassPreviewMessage.getMsgType())) {
            JSONObject news = new JSONObject();
            news.put("media_id", wxMpMassPreviewMessage.getMediaId());
            json.put(WxConstant.MassMsgType.MPNEWS, news);
        }
        if (WxConstant.MassMsgType.TEXT.equals(wxMpMassPreviewMessage.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("content", wxMpMassPreviewMessage.getContent());
            json.put(WxConstant.MassMsgType.TEXT, sub);
        }
        if (WxConstant.MassMsgType.VOICE.equals(wxMpMassPreviewMessage.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", wxMpMassPreviewMessage.getMediaId());
            json.put(WxConstant.MassMsgType.VOICE, sub);
        }
        if (WxConstant.MassMsgType.IMAGE.equals(wxMpMassPreviewMessage.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", wxMpMassPreviewMessage.getMediaId());
            json.put(WxConstant.MassMsgType.IMAGE, sub);
        }
        if (WxConstant.MassMsgType.MPVIDEO.equals(wxMpMassPreviewMessage.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", wxMpMassPreviewMessage.getMediaId());
            json.put(WxConstant.MassMsgType.MPVIDEO, sub);
        }
        json.put("msgtype", wxMpMassPreviewMessage.getMsgType());
        return json;
    }
}
