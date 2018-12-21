package com.xinba.wechat.mp.util.json;


import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMediaImgUploadResult;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:50
 *
 * 媒体图片上传JSON解析
 */
public class WxMediaImgUploadResultJsonAdapter implements JsonDeserializer<WxMediaImgUploadResult> {

    @Override
    public WxMediaImgUploadResult deserialize(JSONObject json,Type type)
    {
        WxMediaImgUploadResult wxMediaImgUploadResult = new WxMediaImgUploadResult();
        if (null != json.get("url") && !StringUtils.isAllEmpty(json.getString("url"))) {
            wxMediaImgUploadResult.setUrl(json.getString("url"));
        }
        return wxMediaImgUploadResult;
    }
}
