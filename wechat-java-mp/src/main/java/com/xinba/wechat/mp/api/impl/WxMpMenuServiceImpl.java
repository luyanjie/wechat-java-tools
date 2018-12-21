package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.bean.menu.WxMenu;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpMenuService;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import com.xinba.wechat.mp.bean.menu.WxMpMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Binary Wang on 2016/7/21.
 */
public class WxMpMenuServiceImpl implements WxMpMenuService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/menu";
    private static Logger log = LoggerFactory.getLogger(WxMpMenuServiceImpl.class);

    private WxMpService wxMpService;

    public WxMpMenuServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public String menuCreate(WxMenu menu) throws WxErrorException {
        String menuJson = menu.toJson();
        String url = API_URL_PREFIX + "/create";
        if (menu.getMatchRule() != null) {
            url = API_URL_PREFIX + "/addconditional";
        }

        log.debug("开始创建菜单：{}", menuJson);

        String result = this.wxMpService.post(url, menuJson);
        log.debug("创建菜单：{},结果：{}", menuJson, result);

        if (menu.getMatchRule() != null) {
            return JSON.parseObject(result).getString("menuid");
        }

        return null;
    }

    @Override
    public String menuCreate(String json) throws WxErrorException {
        JSONObject jsonObject = JSON.parseObject(json);
        String url = API_URL_PREFIX + "/create";
        if (jsonObject.get("matchrule") != null) {
            url = API_URL_PREFIX + "/addconditional";
        }

        String result = this.wxMpService.post(url, json);
        if (jsonObject.get("matchrule") != null) {
            return JSON.parseObject(result).getString("menuid");
        }

        return null;
    }

    @Override
    public void menuDelete() throws WxErrorException {
        String url = API_URL_PREFIX + "/delete";
        String result = this.wxMpService.get(url, null);
        log.debug("删除菜单结果：{}", result);
    }

    @Override
    public void menuDelete(String menuId) throws WxErrorException {
        String url = API_URL_PREFIX + "/delconditional";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("menuid", menuId);
        String result = this.wxMpService.post(url, jsonObject.toString());
        log.debug("根据MeunId({})删除个性化菜单结果：{}", menuId, result);
    }

    @Override
    public WxMpMenu menuGet() throws WxErrorException {
        String url = API_URL_PREFIX + "/get";
        try {
            String resultContent = this.wxMpService.get(url, null);
            return WxMpMenu.fromJson(resultContent);
        } catch (WxErrorException e) {
            // 46003 不存在的菜单数据
            if (e.getError().getErrorCode() == 46003) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public WxMenu menuTryMatch(String userid) throws WxErrorException {
        String url = API_URL_PREFIX + "/trymatch";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userid);
        try {
            String resultContent = this.wxMpService.post(url, jsonObject.toString());
            return WxMenu.fromJson(resultContent);
        } catch (WxErrorException e) {
            // 46003 不存在的菜单数据；46002 不存在的菜单版本
            if (e.getError().getErrorCode() == 46003
                    || e.getError().getErrorCode() == 46002) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() throws WxErrorException {
        String url = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info";
        String resultContent = this.wxMpService.get(url, null);
        return WxMpGetSelfMenuInfoResult.fromJson(resultContent);
    }
}
