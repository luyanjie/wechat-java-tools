package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpMassMessageService;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.*;
import com.xinba.wechat.mp.bean.result.WxMpMassSendResult;
import com.xinba.wechat.mp.bean.result.WxMpMassUploadResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 群发消息服务类
 * Created by Binary Wang on 2017-8-16.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpMassMessageServiceImpl implements WxMpMassMessageService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private WxMpService wxMpService;

    public WxMpMassMessageServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpMassUploadResult massNewsUpload(WxMpMassNews news) throws WxErrorException {
        String responseContent = this.wxMpService.post(MEDIA_UPLOAD_NEWS_URL, news.toJson());
        return WxMpMassUploadResult.fromJson(responseContent);
    }

    @Override
    public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) throws WxErrorException {
        String responseContent = this.wxMpService.post(MEDIA_UPLOAD_VIDEO_URL, video.toJson());
        return WxMpMassUploadResult.fromJson(responseContent);
    }

    @Override
    public WxMpMassSendResult massGroupMessageSend(WxMpMassTagMessage message) throws WxErrorException {
        String responseContent = this.wxMpService.post(WxMpMassMessageService.MESSAGE_MASS_SENDALL_URL, message.toJson());
        return WxMpMassSendResult.fromJson(responseContent);
    }

    @Override
    public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException {
        String responseContent = this.wxMpService.post(MESSAGE_MASS_SEND_URL, message.toJson());
        return WxMpMassSendResult.fromJson(responseContent);
    }

    @Override
    public WxMpMassSendResult massMessagePreview(WxMpMassPreviewMessage wxMpMassPreviewMessage) throws WxErrorException {
        String responseContent = this.wxMpService.post(MESSAGE_MASS_PREVIEW_URL, wxMpMassPreviewMessage.toJson());
        return WxMpMassSendResult.fromJson(responseContent);
    }

    @Override
    public void delete(Long msgId, Integer articleIndex) throws WxErrorException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_id", msgId);
        jsonObject.put("article_idx", articleIndex);
        this.wxMpService.post(MESSAGE_MASS_DELETE_URL, jsonObject.toString());
    }
}
