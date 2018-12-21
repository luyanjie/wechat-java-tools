package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.subscribe.WxMpSubscribeMessage;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpSubscribeMessageGsonAdapter implements JsonSerializer<WxMpSubscribeMessage> {

  @Override
  public JSONObject serialize(WxMpSubscribeMessage message, Type type) {
    JSONObject messageJson = new JSONObject();
    messageJson.put("touser", message.getToUser());
    messageJson.put("template_id", message.getTemplateId());

    if (message.getUrl() != null) {
      messageJson.put("url", message.getUrl());
    }

    final WxMpSubscribeMessage.MiniProgram miniProgram = message.getMiniProgram();
    if (miniProgram != null) {
      JSONObject miniProgramJson = new JSONObject();
      miniProgramJson.put("appid", miniProgram.getAppid());
      if (miniProgram.isUsePath()) {
        miniProgramJson.put("path", miniProgram.getPagePath());
      } else {
        miniProgramJson.put("pagepath", miniProgram.getPagePath());
      }
      messageJson.put("miniprogram", miniProgramJson);
    }

    messageJson.put("scene", message.getScene());
    messageJson.put("title", message.getTitle());

    JSONObject data = new JSONObject();
    messageJson.put("data", data);

    JSONObject content = new JSONObject();
    data.put("content", content);

    if (message.getContentValue() != null) {
      content.put("value", message.getContentValue());
    }

    if (message.getContentColor() != null) {
      content.put("color", message.getContentColor());
    }

    return messageJson;

  }
}
