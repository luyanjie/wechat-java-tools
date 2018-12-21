package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpWifiService;
import com.xinba.wechat.mp.bean.wifi.WxMpWifiShopListResult;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/10.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpWifiServiceImpl implements WxMpWifiService {
    private WxMpService wxMpService;

    public WxMpWifiServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpWifiShopListResult listShop(int pageIndex, int pageSize) throws WxErrorException {
        JSONObject json = new JSONObject();
        json.put("pageindex", pageIndex);
        json.put("pagesize", pageSize);
        final String result = this.wxMpService.post("https://api.weixin.qq.com/bizwifi/shop/list", json.toString());
        return WxMpWifiShopListResult.fromJson(result);
    }
}
