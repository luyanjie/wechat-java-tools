package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpSemanticQueryResult;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpSemanticQueryResultAdapter implements JsonDeserializer<WxMpSemanticQueryResult> {

  @Override
  public WxMpSemanticQueryResult deserialize(JSONObject json, Type type) {
    WxMpSemanticQueryResult result = new WxMpSemanticQueryResult();

    if (json.getString("query") != null) {
      result.setQuery(json.getString("query"));
    }
    if (json.getString( "type") != null) {
      result.setType(json.getString("type"));
    }
    if (json.getString( "semantic") != null) {
      result.setSemantic(json.getString( "semantic"));
    }
    if (json.getString( "result") != null) {
      result.setResult(json.getString( "result"));
    }
    if (json.getString( "answer") != null) {
      result.setAnswer(json.getString( "answer"));
    }
    if (json.getString(  "text") != null) {
      result.setText(json.getString( "text"));
    }
    return result;
  }

}
