package com.xinba.wechat.mp.api.impl;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.SimplePostRequestExecutor;
import com.xinba.wechat.common.util.json.JsonUtils;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpUserBlacklistService;
import com.xinba.wechat.mp.bean.result.WxMpUserBlacklistGetResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author miller
 */
public class WxMpUserBlacklistServiceImpl implements WxMpUserBlacklistService {
    private static final String API_BLACKLIST_PREFIX = "https://api.weixin.qq.com/cgi-bin/tags/members";
    private WxMpService wxMpService;

    public WxMpUserBlacklistServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpUserBlacklistGetResult getBlacklist(String nextOpenid) throws WxErrorException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_openid", nextOpenid);
        String url = API_BLACKLIST_PREFIX + "/getblacklist";
        String responseContent = this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, jsonObject.toString());
        return WxMpUserBlacklistGetResult.fromJson(responseContent);
    }

    @Override
    public void pushToBlacklist(List<String> openidList) throws WxErrorException {
        Map<String, Object> map = new HashMap<>();
        map.put("openid_list", openidList);
        String url = API_BLACKLIST_PREFIX + "/batchblacklist";
        this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, JsonUtils.toJSONString(map));
    }

    @Override
    public void pullFromBlacklist(List<String> openidList) throws WxErrorException {
        Map<String, Object> map = new HashMap<>();
        map.put("openid_list", openidList);
        String url = API_BLACKLIST_PREFIX + "/batchunblacklist";
        this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, JsonUtils.toJSONString(map));
    }
}
