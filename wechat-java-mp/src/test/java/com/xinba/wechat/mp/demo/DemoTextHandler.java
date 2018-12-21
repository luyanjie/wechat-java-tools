package com.xinba.wechat.mp.demo;

import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.api.WxMpMessageHandler;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutTextMessage;

import java.util.Map;

/**
 * Created by qianjia on 15/1/22.
 */
public class DemoTextHandler implements WxMpMessageHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
                                    WxMpService wxMpService, WxSessionManager sessionManager) {
        WxMpXmlOutTextMessage m
                = WxMpXmlOutMessage.TEXT().content("测试加密消息").fromUser(wxMessage.getToUser())
                .toUser(wxMessage.getFromUser()).build();
        return m;
    }

}
