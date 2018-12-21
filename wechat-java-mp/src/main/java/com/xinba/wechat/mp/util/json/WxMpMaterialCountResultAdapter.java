package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.material.WxMpMaterialCountResult;

import java.lang.reflect.Type;

/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMaterialCountResultAdapter implements JsonDeserializer<WxMpMaterialCountResult> {

  @Override
  public WxMpMaterialCountResult deserialize(JSONObject json, Type type) {
    WxMpMaterialCountResult countResult = new WxMpMaterialCountResult();

    if (json.get("voice_count") != null ) {
      countResult.setVoiceCount(json.getInteger("voice_count"));
    }
    if (json.get("video_count") != null ) {
      countResult.setVideoCount(json.getInteger("video_count"));
    }
    if (json.get("image_count") != null ) {
      countResult.setImageCount(json.getInteger("image_count"));
    }
    if (json.get("news_count") != null ) {
      countResult.setNewsCount(json.getInteger("news_count"));
    }
    return countResult;
  }

}
