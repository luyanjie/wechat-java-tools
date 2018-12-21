package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 */
public interface JsonDeserializer<T> {
    T deserialize(JSONObject json, Type type);
}
