package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialUploadResult;

import java.lang.reflect.Type;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialUploadResultAdapter implements JsonDeserializer<WxMpMaterialUploadResult> {

  @Override
  public WxMpMaterialUploadResult deserialize(JSONObject json, Type type) {
    WxMpMaterialUploadResult uploadResult = new WxMpMaterialUploadResult();

    if (json.get("url") != null ) {
      uploadResult.setUrl(json.getString("url"));
    }
    if (json.get("media_id") != null ) {
      uploadResult.setMediaId(json.getString("media_id"));
    }
    return uploadResult;
  }

}
