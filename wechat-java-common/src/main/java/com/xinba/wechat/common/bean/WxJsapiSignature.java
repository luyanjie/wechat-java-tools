package com.xinba.wechat.common.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 14:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxJsapiSignature implements Serializable {
    private static final long serialVersionUID = -8469393958208734863L;

    private String appId;

    private String nonceStr;

    private long timestamp;

    private String url;

    private String signature;
}
