package com.xinba.wechat.common.util.json;

import com.alibaba.fastjson.JSON;

/**
 * @author jokin
 * @date 2018/12/21 10:36
 */
public class JsonUtils {
    public static  String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }
}
