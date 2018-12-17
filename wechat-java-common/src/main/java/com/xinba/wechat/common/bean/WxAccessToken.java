package com.xinba.wechat.common.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 14:44
 * <p>
 * access token
 */
@Data
public class WxAccessToken implements Serializable {
    private static final long serialVersionUID = 2093206679093605533L;

    private String accessToken;

    private int expiresIn = -1;

    public static WxAccessToken fromJson(String json) {
        return JSON.parseObject(json, WxAccessToken.class);
    }
}
