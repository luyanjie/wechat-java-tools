package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.result.WxMpUser;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 */
public class WxMpUserGsonAdapter implements JsonDeserializer<WxMpUser> {

    @Override
    public WxMpUser deserialize(JSONObject json, Type type) {
        WxMpUser user = new WxMpUser();
        Integer subscribe = json.getInteger("subscribe");
        if (subscribe != null) {
            user.setSubscribe(!new Integer(0).equals(subscribe));
        }
        user.setCity(json.getString("city"));
        user.setCountry(json.getString("country"));
        user.setHeadImgUrl(json.getString("headimgurl"));
        user.setLanguage(json.getString("language"));
        user.setNickname(json.getString("nickname"));
        user.setOpenId(json.getString("openid"));
        user.setProvince(json.getString("province"));
        user.setSubscribeTime(json.getLong("subscribe_time"));
        user.setUnionId(json.getString("unionid"));
        user.setRemark(json.getString("remark"));
        user.setGroupId(json.getInteger("groupid"));
        user.setTagIds((Long[]) json.getJSONArray("tagid_list").toArray());
        user.setPrivileges((String[]) json.getJSONArray("privilege").toArray());
        user.setSubscribeScene(json.getString("subscribe_scene"));
        user.setQrScene(json.getString("qr_scene"));
        user.setQrSceneStr(json.getString("qr_scene_str"));

        Integer sex = json.getInteger("sex");
        if (sex != null) {
            user.setSex(sex);
            switch (sex) {
                case 1:
                    user.setSexDesc("男");
                    break;
                case 2:
                    user.setSexDesc("女");
                    break;
                default:
                    user.setSexDesc("未知");
            }

        }
        return user;
    }

}
