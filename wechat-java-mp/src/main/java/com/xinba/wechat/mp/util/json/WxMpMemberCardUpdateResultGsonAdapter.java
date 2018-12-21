package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.membercard.WxMpMemberCardUpdateResult;

import java.lang.reflect.Type;

/**
 *
 * @author jokin
 * @date 2018/12/18 15:55
 * */
public class WxMpMemberCardUpdateResultGsonAdapter implements JsonDeserializer<WxMpMemberCardUpdateResult> {

    @Override
    public WxMpMemberCardUpdateResult deserialize(JSONObject json, Type type) {

        WxMpMemberCardUpdateResult result = new WxMpMemberCardUpdateResult();

        result.setOpenId(json.getString("openid"));
        result.setErrorCode(json.getString("errcode"));
        result.setErrorMsg(json.getString("errmsg"));
        result.setResultBalance(json.getDouble("result_balance"));
        result.setResultBonus(json.getInteger("result_bonus"));

        return result;
    }
}
