package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpUserTagService;
import com.xinba.wechat.mp.bean.tag.WxTagListUser;
import com.xinba.wechat.mp.bean.tag.WxUserTag;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Binary Wang on 2016/9/2.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpUserTagServiceImpl implements WxMpUserTagService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/tags";

    private WxMpService wxMpService;

    public WxMpUserTagServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxUserTag tagCreate(String name) throws WxErrorException {
        String url = API_URL_PREFIX + "/create";
        JSONObject json = new JSONObject();
        JSONObject tagJson = new JSONObject();
        tagJson.put("name", name);
        json.put("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        return WxUserTag.fromJson(responseContent);
    }

    @Override
    public List<WxUserTag> tagGet() throws WxErrorException {
        String url = API_URL_PREFIX + "/get";

        String responseContent = this.wxMpService.get(url, null);
        return WxUserTag.listFromJson(responseContent);
    }

    @Override
    public Boolean tagUpdate(Long id, String name) throws WxErrorException {
        String url = API_URL_PREFIX + "/update";

        JSONObject json = new JSONObject();
        JSONObject tagJson = new JSONObject();
        tagJson.put("id", id);
        tagJson.put("name", name);
        json.put("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent, WxType.MP);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public Boolean tagDelete(Long id) throws WxErrorException {
        String url = API_URL_PREFIX + "/delete";

        JSONObject json = new JSONObject();
        JSONObject tagJson = new JSONObject();
        tagJson.put("id", id);
        json.put("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent, WxType.MP);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public WxTagListUser tagListUser(Long tagId, String nextOpenid)
            throws WxErrorException {
        String url = "https://api.weixin.qq.com/cgi-bin/user/tag/get";

        JSONObject json = new JSONObject();
        json.put("tagid", tagId);
        json.put("next_openid", StringUtils.trimToEmpty(nextOpenid));

        String responseContent = this.wxMpService.post(url, json.toString());
        return WxTagListUser.fromJson(responseContent);
    }

    @Override
    public boolean batchTagging(Long tagId, String[] openids)
            throws WxErrorException {
        String url = API_URL_PREFIX + "/members/batchtagging";

        JSONObject json = new JSONObject();
        json.put("tagid", tagId);
        JSONArray openidArrayJson = new JSONArray();
        for (String openid : openids) {
            openidArrayJson.add(openid);
        }
        json.put("openid_list", openidArrayJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent, WxType.MP);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public boolean batchUntagging(Long tagId, String[] openids)
            throws WxErrorException {
        String url = API_URL_PREFIX + "/members/batchuntagging";

        JSONObject json = new JSONObject();
        json.put("tagid", tagId);
        JSONArray openidArrayJson = new JSONArray();
        for (String openid : openids) {
            openidArrayJson.add(openid);
        }
        json.put("openid_list", openidArrayJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent, WxType.MP);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public List<Long> userTagList(String openid) throws WxErrorException {
        String url = API_URL_PREFIX + "/getidlist";

        JSONObject json = new JSONObject();
        json.put("openid", openid);

        String responseContent = this.wxMpService.post(url, json.toString());
        return JSON.parseObject(JSON.parseObject(responseContent).getString("tagid_list"), new TypeReference<List<Long>>() {
        });

    }
}
