package com.xinba.wechat.mp.util.json;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.template.WxMpTemplateData;
import com.xinba.wechat.mp.bean.template.WxMpTemplateMessage;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpTemplateMessageGsonAdapter implements JsonSerializer<WxMpTemplateMessage> {

  @Override
  public JSONObject serialize(WxMpTemplateMessage message, Type type) {
    JSONObject messageJson = new JSONObject();
    messageJson.put("touser", message.getToUser());
    messageJson.put("template_id", message.getTemplateId());
    if (message.getUrl() != null) {
      messageJson.put("url", message.getUrl());
    }

    final WxMpTemplateMessage.MiniProgram miniProgram = message.getMiniProgram();
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

    JSONObject data = new JSONObject();
    messageJson.put("data", data);

    for (WxMpTemplateData datum : message.getData()) {
      JSONObject dataJson = new JSONObject();
      dataJson.put("value", datum.getValue());
      if (datum.getColor() != null) {
        dataJson.put("color", datum.getColor());
      }
      data.put(datum.getName(), dataJson);
    }

    return messageJson;
  }

}
