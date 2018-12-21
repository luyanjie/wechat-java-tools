package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Collection;

/**
 * @author jokin
 * @date 2018-12-18
 * <p>
 * 摇一摇 附近的设备
 */

@Data
public class WxMpShakeAroundDeviceBindPageQuery {
    private WxMpDeviceIdentifier deviceIdentifier;
    private Collection<Integer> pageIds;

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("device_identifier", deviceIdentifier.toJsonObject());
        JSONArray jsonArray = new JSONArray();
        for (Integer pageid : pageIds) {
            jsonArray.add(pageid);
        }
        jsonObject.put("page_ids", jsonArray);
        return jsonObject.toString();
    }
}
