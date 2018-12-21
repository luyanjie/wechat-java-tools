package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:32
 */
public interface JsonSerializer<T> {
    JSONObject serialize(T var1, Type var2);
}
