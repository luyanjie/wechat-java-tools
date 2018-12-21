package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpQrCodeTicket;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxQrCodeTicketAdapter implements JsonDeserializer<WxMpQrCodeTicket> {

  @Override
  public WxMpQrCodeTicket deserialize(JSONObject json, Type type) {
    WxMpQrCodeTicket ticket = new WxMpQrCodeTicket();
    if (json.get("ticket") != null) {
      ticket.setTicket(json.getString("ticket"));
    }
    if (json.get("expire_seconds") != null) {
      ticket.setExpireSeconds(json.getInteger("expire_seconds"));
    }
    if (json.get("url") != null ) {
      ticket.setUrl(json.getString("url"));
    }
    return ticket;
  }

}
