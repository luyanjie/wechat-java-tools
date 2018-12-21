package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.WxMpCard;
import com.xinba.wechat.mp.bean.result.WxMpCardResult;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:01
 * <p>
 * 卡券查询Code
 */
public class WxMpCardResultJsonAdapter implements JsonDeserializer<WxMpCardResult> {
    @Override
    public WxMpCardResult deserialize(JSONObject json, Type type) {
        WxMpCardResult cardResult = new WxMpCardResult();

        cardResult.setOpenId(json.getString("openid"));
        cardResult.setErrorCode(json.getString("errcode"));
        cardResult.setErrorMsg(json.getString("errmsg"));
        cardResult.setCanConsume(json.getBoolean("can_consume"));
        cardResult.setUserCardStatus(json.getString("user_card_status"));
        WxMpCard card = JSON.parseObject(json.getString("card"), WxMpCard.class);
        cardResult.setCard(card);
        return cardResult;
    }
}
