package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpOAuth2AccessToken;

import java.lang.reflect.Type;
/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpOAuth2AccessTokenAdapter implements JsonDeserializer<WxMpOAuth2AccessToken> {

  @Override
  public WxMpOAuth2AccessToken deserialize(JSONObject json, Type type){
    WxMpOAuth2AccessToken accessToken = new WxMpOAuth2AccessToken();

    if (json.get("access_token") != null) {
      accessToken.setAccessToken(json.getString("access_token"));
    }
    if (json.get("expires_in") != null) {
      accessToken.setExpiresIn(json.getInteger("expires_in"));
    }
    if (json.get("refresh_token") != null) {
      accessToken.setRefreshToken(json.getString("refresh_token"));
    }
    if (json.get("openid") != null ) {
      accessToken.setOpenId(json.getString("openid"));
    }
    if (json.get("scope") != null) {
      accessToken.setScope(json.getString("scope"));
    }
    if (json.get("unionid") != null) {
      accessToken.setUnionId(json.getString("unionid"));
    }
    return accessToken;
  }

}
