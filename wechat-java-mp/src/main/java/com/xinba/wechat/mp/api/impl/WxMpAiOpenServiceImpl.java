package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.AiLangType;
import com.xinba.wechat.mp.api.WxMpAiOpenService;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.util.requestexecuter.voice.VoiceUploadRequestExecutor;

import java.io.File;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/9.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpAiOpenServiceImpl implements WxMpAiOpenService {


    public static final String TRANSLATE_URL = "http://api.weixin.qq.com/cgi-bin/media/voice/translatecontent?lfrom=%s&lto=%s";
    private WxMpService wxMpService;

    public WxMpAiOpenServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public void uploadVoice(String voiceId, AiLangType lang, File voiceFile) throws WxErrorException {
        if (lang == null) {
            lang = AiLangType.zh_CN;
        }

        this.wxMpService.execute(VoiceUploadRequestExecutor.create(this.wxMpService.getRequestHttp()),
                String.format(VOICE_UPLOAD_URL, "mp3", voiceId, lang.getCode()),
                voiceFile);
    }

    @Override
    public String recogniseVoice(String voiceId, AiLangType lang, File voiceFile) throws WxErrorException {
        this.uploadVoice(voiceId, lang, voiceFile);
        return this.queryRecognitionResult(voiceId, lang);
    }

    @Override
    public String translate(AiLangType langFrom, AiLangType langTo, String content) throws WxErrorException {
        final String responseContent = this.wxMpService.post(String.format(TRANSLATE_URL, langFrom.getCode(), langTo.getCode()),
                content);
        final JSONObject jsonObject = JSON.parseObject(responseContent);
        if (jsonObject.get("errcode") == null || jsonObject.getIntValue("errcode") == 0) {
            return jsonObject.getString("to_content");
        }

        throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }

    @Override
    public String queryRecognitionResult(String voiceId, AiLangType lang) throws WxErrorException {
        if (lang == null) {
            lang = AiLangType.zh_CN;
        }

        final String responseContent = this.wxMpService.get(VOICE_QUERY_RESULT_URL,
                String.format("voice_id=%s&lang=%s", voiceId, lang.getCode()));
        final JSONObject jsonObject = JSON.parseObject(responseContent);
        if (jsonObject.get("errcode") == null || jsonObject.getIntValue("errcode") == 0) {
            return jsonObject.getString("result");
        }

        throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }
}
