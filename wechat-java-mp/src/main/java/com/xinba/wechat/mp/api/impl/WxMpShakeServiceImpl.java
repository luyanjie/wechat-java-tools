package com.xinba.wechat.mp.api.impl;

import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpShakeService;
import com.xinba.wechat.mp.bean.WxMpShakeInfoResult;
import com.xinba.wechat.mp.bean.WxMpShakeQuery;
import com.xinba.wechat.mp.bean.shake.*;

/**
 * Created by rememberber on 2017/6/5.
 *
 * @author rememberber
 */
public class WxMpShakeServiceImpl implements WxMpShakeService {

    private WxMpService wxMpService;

    public WxMpShakeServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    /**
     * <pre>
     * 获取设备及用户信息<br/>
     * 获取设备信息，包括UUID、major、minor，以及距离、openID等信息。
     * 详情请见: https://mp.weixin.qq.com/wiki?action=doc&id=mp1443447963
     * http请求方式: POST（请使用https协议）
     * 接口地址：https://api.weixin.qq.com/shakearound/user/getshakeinfo?access_token=ACCESS_TOKE
     * </pre>
     *
     * @param wxMpShakeQuery 查询参数
     */
    @Override
    public WxMpShakeInfoResult getShakeInfo(WxMpShakeQuery wxMpShakeQuery) throws WxErrorException {
        String url = "https://api.weixin.qq.com/shakearound/user/getshakeinfo";
        String postData = wxMpShakeQuery.toJson();
        String responseContent = this.wxMpService.post(url, postData);
        return WxMpShakeInfoResult.fromJson(responseContent);
    }

    @Override
    public WxMpShakeAroundPageAddResult pageAdd(WxMpShakeAroundPageAddQuery shakeAroundPageAddQuery) throws WxErrorException {
        String url = "https://api.weixin.qq.com/shakearound/page/add";
        String postData = shakeAroundPageAddQuery.toJsonString();
        String responseContent = this.wxMpService.post(url, postData);
        return WxMpShakeAroundPageAddResult.fromJson(responseContent);
    }

    @Override
    public WxError deviceBindPageQuery(WxMpShakeAroundDeviceBindPageQuery shakeAroundDeviceBindPageQuery) throws WxErrorException {
        String url = "https://api.weixin.qq.com/shakearound/device/bindpage";
        String postData = shakeAroundDeviceBindPageQuery.toJsonString();
        String responseContent = this.wxMpService.post(url, postData);
        return WxError.fromJson(responseContent, WxType.MP);
    }

    @Override
    public WxMpShakeAroundRelationSearchResult relationSearch(WxMpShakeAroundRelationSearchQuery shakeAroundRelationSearchQuery) throws WxErrorException {
        String url = "https://api.weixin.qq.com/shakearound/relation/search";
        String postData = shakeAroundRelationSearchQuery.toJsonString();
        String responseContent = this.wxMpService.post(url, postData);
        return WxMpShakeAroundRelationSearchResult.fromJson(responseContent);
    }
}
