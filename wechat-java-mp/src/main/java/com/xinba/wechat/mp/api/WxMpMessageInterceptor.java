package com.xinba.wechat.mp.api;

import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;

import java.util.Map;

/**
 * 微信消息拦截器，可以用来做验证
 *
 * @author Daniel Qian
 */
public interface WxMpMessageInterceptor {

  /**
   * 拦截微信消息
   *
   * @param wxMessage
   * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
   * @param wxMpService
   * @param sessionManager
   * @return true代表OK，false代表不OK
   */
  boolean intercept(WxMpXmlMessage wxMessage,
                    Map<String, Object> context,
                    WxMpService wxMpService,
                    WxSessionManager sessionManager) throws WxErrorException;

}
