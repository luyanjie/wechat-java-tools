package com.xinba.wechat.mp.bean.kefu;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 */
public abstract class AbstractKefuBean implements Serializable
{
    private static final long serialVersionUID = -4588125520533228541L;

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public static <T> T fromJson(String json, Class<T> t) {
        return JSON.parseObject(json, t);
    }
}