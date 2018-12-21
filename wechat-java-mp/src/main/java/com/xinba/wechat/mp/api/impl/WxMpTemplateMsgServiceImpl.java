package com.xinba.wechat.mp.api.impl;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpTemplateMsgService;
import com.xinba.wechat.mp.bean.template.WxMpTemplate;
import com.xinba.wechat.mp.bean.template.WxMpTemplateIndustry;
import com.xinba.wechat.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

/**
 * <pre>
 * Created by Binary Wang on 2016-10-14.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpTemplateMsgServiceImpl implements WxMpTemplateMsgService {
    public static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/template";


    private WxMpService wxMpService;

    public WxMpTemplateMsgServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public String sendTemplateMsg(WxMpTemplateMessage templateMessage) throws WxErrorException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send";
        String responseContent = this.wxMpService.post(url, templateMessage.toJson());
        final JSONObject jsonObject = JSONObject.parseObject(responseContent);
        if (jsonObject.getIntValue("errcode") == 0) {
            return jsonObject.getString("msgid");
        }
        throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }

    @Override
    public boolean setIndustry(WxMpTemplateIndustry wxMpIndustry) throws WxErrorException {
        if (null == wxMpIndustry.getPrimaryIndustry() || null == wxMpIndustry.getPrimaryIndustry().getId()
                || null == wxMpIndustry.getSecondIndustry() || null == wxMpIndustry.getSecondIndustry().getId()) {
            throw new IllegalArgumentException("行业Id不能为空，请核实");
        }

        String url = API_URL_PREFIX + "/api_set_industry";
        this.wxMpService.post(url, wxMpIndustry.toJson());
        return true;
    }

    @Override
    public WxMpTemplateIndustry getIndustry() throws WxErrorException {
        String url = API_URL_PREFIX + "/get_industry";
        String responseContent = this.wxMpService.get(url, null);
        return WxMpTemplateIndustry.fromJson(responseContent);
    }

    @Override
    public String addTemplate(String shortTemplateId) throws WxErrorException {
        String url = API_URL_PREFIX + "/api_add_template";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id_short", shortTemplateId);
        String responseContent = this.wxMpService.post(url, jsonObject.toString());
        final JSONObject result = JSONObject.parseObject(responseContent);
        if (result.getIntValue("errcode") == 0) {
            return result.getString("template_id");
        }

        throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }

    @Override
    public List<WxMpTemplate> getAllPrivateTemplate() throws WxErrorException {
        String url = API_URL_PREFIX + "/get_all_private_template";
        return WxMpTemplate.fromJson(this.wxMpService.get(url, null));
    }

    @Override
    public boolean delPrivateTemplate(String templateId) throws WxErrorException {
        String url = API_URL_PREFIX + "/del_private_template";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id", templateId);
        String responseContent = this.wxMpService.post(url, jsonObject.toString());
        WxError error = WxError.fromJson(responseContent, WxType.MP);
        if (error.getErrorCode() == 0) {
            return true;
        }
        throw new WxErrorException(error);
    }
}
