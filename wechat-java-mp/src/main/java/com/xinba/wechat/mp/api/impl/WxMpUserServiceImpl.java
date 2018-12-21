package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpUserService;
import com.xinba.wechat.mp.bean.WxMpUserQuery;
import com.xinba.wechat.mp.bean.result.WxMpUser;
import com.xinba.wechat.mp.bean.result.WxMpUserList;

import java.util.List;

/**
 * Created by Binary Wang on 2016/7/21.
 */
public class WxMpUserServiceImpl implements WxMpUserService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/user";
    private WxMpService wxMpService;

    public WxMpUserServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public void userUpdateRemark(String openid, String remark) throws WxErrorException {
        String url = API_URL_PREFIX + "/info/updateremark";
        JSONObject json = new JSONObject();
        json.put("openid", openid);
        json.put("remark", remark);
        this.wxMpService.post(url, json.toString());
    }

    @Override
    public WxMpUser userInfo(String openid) throws WxErrorException {
        return this.userInfo(openid, null);
    }

    @Override
    public WxMpUser userInfo(String openid, String lang) throws WxErrorException {
        String url = API_URL_PREFIX + "/info";
        lang = lang == null ? "zh_CN" : lang;
        String responseContent = this.wxMpService.get(url,
                "openid=" + openid + "&lang=" + lang);
        return WxMpUser.fromJson(responseContent);
    }

    @Override
    public WxMpUserList userList(String next_openid) throws WxErrorException {
        String url = API_URL_PREFIX + "/get";
        String responseContent = this.wxMpService.get(url,
                next_openid == null ? null : "next_openid=" + next_openid);
        return WxMpUserList.fromJson(responseContent);
    }

    @Override
    public List<WxMpUser> userInfoList(List<String> openids)
            throws WxErrorException {
        return this.userInfoList(new WxMpUserQuery(openids));
    }

    @Override
    public List<WxMpUser> userInfoList(WxMpUserQuery userQuery) throws WxErrorException {
        String url = API_URL_PREFIX + "/info/batchget";
        String responseContent = this.wxMpService.post(url,
                userQuery.toJsonString());
        return WxMpUser.fromJsonList(responseContent);
    }

}
