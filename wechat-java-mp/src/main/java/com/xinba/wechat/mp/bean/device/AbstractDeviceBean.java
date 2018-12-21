package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:37
 * <p>
 * 设备抽象类.
 */
public abstract class AbstractDeviceBean implements Serializable {
    private static final long serialVersionUID = 4359729626772515385L;

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public static <T> T fromJson(String json, Class<T> t) {
        return JSON.parseObject(json, t);
    }
}