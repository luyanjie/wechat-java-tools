package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.mp.bean.WxMpMassOpenIdsMessage;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 17:03
 */
public class WxMpMassOpenIdsMessageJsonAdapter implements JsonSerializer<WxMpMassOpenIdsMessage>{
    @Override
    public JSONObject serialize(WxMpMassOpenIdsMessage message, Type var2) {
        JSONObject messageJson = new JSONObject();

        JSONArray toUsers = new JSONArray();
        for (String openId : message.getToUsers()) {
            toUsers.add(openId);
        }
        messageJson.put("touser", toUsers);

        if (WxConstant.MassMsgType.MPNEWS.equals(message.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", message.getMediaId());
            messageJson.put(WxConstant.MassMsgType.MPNEWS, sub);
        }
        if (WxConstant.MassMsgType.TEXT.equals(message.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("content", message.getContent());
            messageJson.put(WxConstant.MassMsgType.TEXT, sub);
        }
        if (WxConstant.MassMsgType.VOICE.equals(message.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", message.getMediaId());
            messageJson.put(WxConstant.MassMsgType.VOICE, sub);
        }
        if (WxConstant.MassMsgType.IMAGE.equals(message.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", message.getMediaId());
            messageJson.put(WxConstant.MassMsgType.IMAGE, sub);
        }
        if (WxConstant.MassMsgType.MPVIDEO.equals(message.getMsgType())) {
            JSONObject sub = new JSONObject();
            sub.put("media_id", message.getMediaId());
            messageJson.put(WxConstant.MassMsgType.MPVIDEO, sub);
        }
        messageJson.put("msgtype", message.getMsgType());
        messageJson.put("send_ignore_reprint", message.isSendIgnoreReprint() ? 0 : 1);

        if(StringUtils.isNotEmpty(message.getClientMsgId())){
            messageJson.put("clientmsgid", message.getClientMsgId());
        }

        return messageJson;
    }
}
