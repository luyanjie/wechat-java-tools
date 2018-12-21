package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.BeanUtils;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.WxMpStoreService;
import com.xinba.wechat.mp.bean.store.WxMpStoreBaseInfo;
import com.xinba.wechat.mp.bean.store.WxMpStoreInfo;
import com.xinba.wechat.mp.bean.store.WxMpStoreListResult;

import java.util.List;

/**
 * Created by Binary Wang on 2016/9/26.
 *
 * @author binarywang (https://github.com/binarywang)
 */
public class WxMpStoreServiceImpl implements WxMpStoreService {
    private WxMpService wxMpService;

    public WxMpStoreServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public void add(WxMpStoreBaseInfo request) throws WxErrorException {
        BeanUtils.checkRequiredFields(request);

        String response = this.wxMpService.post(POI_ADD_URL, request.toJson());
        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpStoreBaseInfo get(String poiId) throws WxErrorException {
        JSONObject paramObject = new JSONObject();
        paramObject.put("poi_id", poiId);
        String response = this.wxMpService.post(POI_GET_URL, paramObject.toString());
        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }

        return WxMpStoreBaseInfo.fromJson(JSON.parseObject(response).getJSONObject("business").getString("base_info"));
    }

    @Override
    public void delete(String poiId) throws WxErrorException {
        JSONObject paramObject = new JSONObject();
        paramObject.put("poi_id", poiId);
        String response = this.wxMpService.post(POI_DEL_URL, paramObject.toString());
        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpStoreListResult list(int begin, int limit)
            throws WxErrorException {
        JSONObject params = new JSONObject();
        params.put("begin", begin);
        params.put("limit", limit);
        String response = this.wxMpService.post(POI_LIST_URL, params.toString());

        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }

        return WxMpStoreListResult.fromJson(response);
    }

    @Override
    public List<WxMpStoreInfo> listAll() throws WxErrorException {
        int limit = 50;
        WxMpStoreListResult list = this.list(0, limit);
        List<WxMpStoreInfo> stores = list.getBusinessList();
        if (list.getTotalCount() > limit) {
            int begin = limit;
            WxMpStoreListResult followingList = this.list(begin, limit);
            while (followingList.getBusinessList().size() > 0) {
                stores.addAll(followingList.getBusinessList());
                begin += limit;
                if (begin >= list.getTotalCount()) {
                    break;
                }
                followingList = this.list(begin, limit);
            }
        }

        return stores;
    }

    @Override
    public void update(WxMpStoreBaseInfo request) throws WxErrorException {
        String response = this.wxMpService.post(POI_UPDATE_URL, request.toJson());
        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public List<String> listCategories() throws WxErrorException {
        String response = this.wxMpService.get(POI_GET_WX_CATEGORY_URL, null);
        WxError wxError = WxError.fromJson(response, WxType.MP);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
        return JSON.parseObject(JSON.parseObject(response).getString("category_list"), new TypeReference<List<String>>() {
        });
    }
}
