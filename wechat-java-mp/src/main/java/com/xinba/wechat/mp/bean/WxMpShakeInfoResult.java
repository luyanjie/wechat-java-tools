package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:23
 * <p>
 * 摇一摇周边：获取设备以及用户信息接口返回JSON数据接收对象
 */
@Data
public class WxMpShakeInfoResult implements Serializable {
    private static final long serialVersionUID = -965807521237119184L;

    private Integer errcode;

    private String errmsg;

    private ShakeInfoData data;

    public static WxMpShakeInfoResult fromJson(String json) {
        return JSON.parseObject(json, WxMpShakeInfoResult.class);
    }

    @Data
    public static class ShakeInfoData implements Serializable{

        private static final long serialVersionUID = -6400684731067152060L;

        private String page_id;

        private String openid;

        private String poi_id;

        private String brand_userame;

        private BeaconInfo beacon_info;

        @Data
        public class BeaconInfo implements Serializable {
            private static final long serialVersionUID = -8995733049982933362L;

            private double distance;

            private Integer major;

            private Integer measure_power;

            private Integer minor;

            private Integer rssi;

            private String uuid;
        }
    }
}
