package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpQrcodeService;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.result.WxMpQrCodeTicket;
import com.xinba.wechat.mp.util.requestexecuter.qrcode.QrCodeRequestExecutor;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by Binary Wang on 2016/7/21.
 */
public class WxMpQrcodeServiceImpl implements WxMpQrcodeService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/qrcode";
    private WxMpService wxMpService;

    public WxMpQrcodeServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpQrCodeTicket qrCodeCreateTmpTicket(int sceneId, Integer expireSeconds) throws WxErrorException {
        if (sceneId == 0) {
            throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("临时二维码场景值不能为0！").build());
        }

        //expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
        if (expireSeconds != null && expireSeconds > 2592000) {
            throw new WxErrorException(WxError.builder().errorCode(-1)
                    .errorMsg("临时二维码有效时间最大不能超过2592000（即30天）！").build());
        }

        if (expireSeconds == null) {
            expireSeconds = 30;
        }

        String url = API_URL_PREFIX + "/create";
        JSONObject json = new JSONObject();
        json.put("action_name", "QR_SCENE");
        json.put("expire_seconds", expireSeconds);

        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_id", sceneId);
        actionInfo.put("scene", scene);
        json.put("action_info", actionInfo);
        String responseContent = this.wxMpService.post(url, json.toString());
        return WxMpQrCodeTicket.fromJson(responseContent);
    }


    @Override
    public WxMpQrCodeTicket qrCodeCreateTmpTicket(String sceneStr, Integer expireSeconds) throws WxErrorException {
        if (StringUtils.isBlank(sceneStr)) {
            throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("临时二维码场景值不能为空！").build());
        }

        //expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
        if (expireSeconds != null && expireSeconds > 2592000) {
            throw new WxErrorException(WxError.builder().errorCode(-1)
                    .errorMsg("临时二维码有效时间最大不能超过2592000（即30天）！").build());
        }

        if (expireSeconds == null) {
            expireSeconds = 30;
        }

        String url = API_URL_PREFIX + "/create";
        JSONObject json = new JSONObject();
        json.put("action_name", "QR_STR_SCENE");
        json.put("expire_seconds", expireSeconds);

        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_str", sceneStr);
        actionInfo.put("scene", scene);
        json.put("action_info", actionInfo);
        String responseContent = this.wxMpService.post(url, json.toString());
        return WxMpQrCodeTicket.fromJson(responseContent);
    }


    @Override
    public WxMpQrCodeTicket qrCodeCreateLastTicket(int sceneId) throws WxErrorException {
        if (sceneId < 1 || sceneId > 100000) {
            throw new WxErrorException(WxError.builder().errorCode(-1)
                    .errorMsg("永久二维码的场景值目前只支持1--100000！")
                    .build());
        }

        String url = API_URL_PREFIX + "/create";
        JSONObject json = new JSONObject();
        json.put("action_name", "QR_LIMIT_SCENE");
        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_id", sceneId);
        actionInfo.put("scene", scene);
        json.put("action_info", actionInfo);
        String responseContent = this.wxMpService.post(url, json.toString());
        return WxMpQrCodeTicket.fromJson(responseContent);
    }

    @Override
    public WxMpQrCodeTicket qrCodeCreateLastTicket(String sceneStr) throws WxErrorException {
        String url = API_URL_PREFIX + "/create";
        JSONObject json = new JSONObject();
        json.put("action_name", "QR_LIMIT_STR_SCENE");
        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_str", sceneStr);
        actionInfo.put("scene", scene);
        json.put("action_info", actionInfo);
        String responseContent = this.wxMpService.post(url, json.toString());
        return WxMpQrCodeTicket.fromJson(responseContent);
    }

    @Override
    public File qrCodePicture(WxMpQrCodeTicket ticket) throws WxErrorException {
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode";
        return this.wxMpService.execute(QrCodeRequestExecutor.create(this.wxMpService.getRequestHttp()), url, ticket);
    }

    @Override
    public String qrCodePictureUrl(String ticket, boolean needShortUrl) throws WxErrorException {
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";
        try {
            String resultUrl = String.format(url,
                    URLEncoder.encode(ticket, StandardCharsets.UTF_8.name()));
            if (needShortUrl) {
                return this.wxMpService.shortUrl(resultUrl);
            }

            return resultUrl;
        } catch (UnsupportedEncodingException e) {
            throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg(e.getMessage()).build());
        }
    }

    @Override
    public String qrCodePictureUrl(String ticket) throws WxErrorException {
        return qrCodePictureUrl(ticket, false);
    }

}
