package com.xinba.wechat.mp.demo;


import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.api.WxMpMessageHandler;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

/**
 * Created by qianjia on 15/1/22.
 */
public class DemoOAuth2Handler implements WxMpMessageHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String href = "<a href=\"" + wxMpService.oauth2buildAuthorizationUrl(
                wxMpService.getWxMpConfigStorage().getOauth2redirectUri(),
                WxConstant.OAuth2Scope.SNSAPI_USERINFO, null) + "\">测试oauth2</a>";
        return WxMpXmlOutMessage.TEXT().content(href)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
    }
}
