package com.xinba.wechat.mp.util.json;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.membercard.MemberCardUserInfo;
import com.xinba.wechat.mp.bean.membercard.NameValues;
import com.xinba.wechat.mp.bean.membercard.WxMpMemberCardUserInfoResult;

import java.lang.reflect.Type;

/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMemberCardUserInfoResultGsonAdapter implements JsonDeserializer<WxMpMemberCardUserInfoResult> {

  @Override
  public WxMpMemberCardUserInfoResult deserialize(JSONObject json, Type type) {
    WxMpMemberCardUserInfoResult result = new WxMpMemberCardUserInfoResult();

    result.setOpenId(json.getString( "openid"));
    result.setErrorCode(json.getString( "errcode"));
    result.setErrorMsg(json.getString( "errmsg"));
    result.setNickname(json.getString( "nickname"));
    result.setMembershipNumber(json.getString("membership_number"));
    result.setBonus(json.getInteger("bonus"));
    result.setBalance(json.getDouble("balance"));
    result.setSex(json.getString("sex"));
    result.setUserCardStatus(json.getString("user_card_status"));
    result.setHasActive(json.getBoolean("has_active"));

    JSONObject userInfoJsonObject = json.getJSONObject("user_info");
    MemberCardUserInfo cardUserInfo = new MemberCardUserInfo();

    JSONArray commonFieldListObj = userInfoJsonObject.getJSONArray("common_field_list");
    NameValues[] commonFieldListValues = new NameValues[commonFieldListObj.size()];
    for (int i = 0; i < commonFieldListObj.size(); i++) {
      JSONObject commonField = commonFieldListObj.getJSONObject(i);
      NameValues commonNameValues = new NameValues();
      commonNameValues.setName(commonField.getString("name"));
      commonNameValues.setValue(commonField.getString("value"));
      commonFieldListValues[i] = commonNameValues;
    }
    cardUserInfo.setCommonFieldList(commonFieldListValues);

    JSONArray customFieldListObj = userInfoJsonObject.getJSONArray("custom_field_list");
    NameValues[] customFieldListValues = new NameValues[customFieldListObj.size()];
    for (int i = 0; i < customFieldListObj.size(); i++) {
      JSONObject customField = customFieldListObj.getJSONObject(i);
      NameValues customNameValues = new NameValues();
      customNameValues.setName(customField.getString("name"));
      customNameValues.setValue(customField.getString( "value"));

      JSONArray valueListArray = customField.getJSONArray("value_list");
      String[] valueList = new String[valueListArray.size()];
      for (int j = 0; j < valueListArray.size(); j++) {
        valueList[j] = valueListArray.getString(i);
      }
      customNameValues.setValueList(valueList);
      customFieldListValues[i] = customNameValues;
    }
    cardUserInfo.setCustomFieldList(customFieldListValues);

    result.setUserInfo(cardUserInfo);

    return result;
  }
}
