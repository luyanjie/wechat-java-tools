package com.xinba.wechat.mp.demo;


import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.session.WxSession;
import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.api.WxMpMessageHandler;
import com.xinba.wechat.mp.api.WxMpMessageMatcher;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.kefu.WxMpKefuMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class DemoGuessNumberHandler implements WxMpMessageHandler, WxMpMessageMatcher {

    private Random random = new Random();

    private Pattern pattern = Pattern.compile("\\d+");

    @Override
    public boolean match(WxMpXmlMessage message) {
        return isUserWantGuess(message) || isUserAnswering(message);
    }

    private boolean isUserWantGuess(WxMpXmlMessage message) {
        return "猜数字".equals(message.getContent());
    }

    private boolean isUserAnswering(WxMpXmlMessage message) {
        return this.pattern.matcher(message.getContent()).matches();
    }

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        if (isUserWantGuess(wxMessage)) {
            letsGo(wxMessage, wxMpService, sessionManager);
        }

        if (isUserAnswering(wxMessage)) {
            giveHint(wxMessage, wxMpService, sessionManager);
        }

        return null;

    }

    protected void letsGo(WxMpXmlMessage wxMessage, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxSession session = sessionManager.getSession(wxMessage.getFromUser());
        if (session.getAttribute("guessing") == null) {
            WxMpKefuMessage m = WxMpKefuMessage
                    .TEXT()
                    .toUser(wxMessage.getFromUser())
                    .content("请猜一个100以内的数字")
                    .build();
            wxMpService.getKefuService().sendKefuMessage(m);
        } else {
            WxMpKefuMessage m = WxMpKefuMessage
                    .TEXT()
                    .toUser(wxMessage.getFromUser())
                    .content("放弃了吗？那请重新猜一个100以内的数字")
                    .build();
            wxMpService.getKefuService().sendKefuMessage(m);
        }

        session.setAttribute("guessing", Boolean.TRUE);
        session.setAttribute("number", this.random.nextInt(100));
    }


    protected void giveHint(WxMpXmlMessage wxMessage, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        WxSession session = sessionManager.getSession(wxMessage.getFromUser());

        if (session.getAttribute("guessing") == null) {
            return;
        }
        boolean guessing = (Boolean) session.getAttribute("guessing");
        if (!guessing) {
            return;
        }

        int answer = (Integer) session.getAttribute("number");
        int guessNumber = Integer.valueOf(wxMessage.getContent());
        if (guessNumber < answer) {
            WxMpKefuMessage m = WxMpKefuMessage
                    .TEXT()
                    .toUser(wxMessage.getFromUser())
                    .content("小了")
                    .build();
            wxMpService.getKefuService().sendKefuMessage(m);

        } else if (guessNumber > answer) {
            WxMpKefuMessage m = WxMpKefuMessage
                    .TEXT()
                    .toUser(wxMessage.getFromUser())
                    .content("大了")
                    .build();
            wxMpService.getKefuService().sendKefuMessage(m);
        } else {
            WxMpKefuMessage m = WxMpKefuMessage
                    .TEXT()
                    .toUser(wxMessage.getFromUser())
                    .content("Bingo!")
                    .build();
            session.removeAttribute("guessing");
            wxMpService.getKefuService().sendKefuMessage(m);
        }
    }
}
