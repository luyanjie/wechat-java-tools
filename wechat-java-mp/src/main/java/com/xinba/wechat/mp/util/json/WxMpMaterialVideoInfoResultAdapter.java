package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialVideoInfoResult;

import java.lang.reflect.Type;
/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialVideoInfoResultAdapter implements JsonDeserializer<WxMpMaterialVideoInfoResult> {

  @Override
  public WxMpMaterialVideoInfoResult deserialize(JSONObject json, Type type) {
    WxMpMaterialVideoInfoResult uploadResult = new WxMpMaterialVideoInfoResult();

    if (json.get("title") != null) {
      uploadResult.setTitle(json.getString("title"));
    }
    if (json.get("description") != null ) {
      uploadResult.setDescription(json.getString("description"));
    }
    if (json.get("down_url") != null) {
      uploadResult.setDownUrl(json.getString("down_url"));
    }
    return uploadResult;
  }

}
