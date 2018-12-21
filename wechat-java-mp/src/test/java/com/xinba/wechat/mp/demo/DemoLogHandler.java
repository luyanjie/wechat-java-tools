package com.xinba.wechat.mp.demo;

import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.api.WxMpMessageHandler;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

/**
 * Created by qianjia on 15/1/22.
 */
public class DemoLogHandler implements WxMpMessageHandler {
  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
                                  WxSessionManager sessionManager) {
    System.out.println(wxMessage.toString());
    return null;
  }
}
