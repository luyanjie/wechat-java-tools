package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.WxMpCard;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:58
 *
 * 微信卡券
 */
public class WxMpCardJsonAdapter implements JsonDeserializer<WxMpCard> {
    @Override
    public WxMpCard deserialize(JSONObject json, Type type) {
        WxMpCard card = new WxMpCard();
        card.setCardId(json.containsKey("card_id") ? json.getString("card_id") : "");
        card.setBeginTime(json.containsKey("begin_time") ? json.getLong("begin_time") : 0L);
        card.setEndTime(json.containsKey("end_time") ? json.getLong("end_time") : 0L);
        return card;
    }
}
