package com.xinba.wechat.mp.demo;

import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.bean.result.WxMediaUploadResult;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.session.WxSessionManager;
import com.xinba.wechat.mp.api.WxMpMessageHandler;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.TestConstants;
import com.xinba.wechat.mp.bean.message.WxMpXmlMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutImageMessage;
import com.xinba.wechat.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

public class DemoImageHandler implements WxMpMessageHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
                                    WxMpService wxMpService, WxSessionManager sessionManager) {
        try {
            WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService()
                    .mediaUpload(WxConstant.MediaFileType.IMAGE, TestConstants.FILE_JPG, ClassLoader.getSystemResourceAsStream("mm.jpeg"));
            WxMpXmlOutImageMessage m
                    = WxMpXmlOutMessage
                    .IMAGE()
                    .mediaId(wxMediaUploadResult.getMediaId())
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
            return m;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return null;
    }
}
