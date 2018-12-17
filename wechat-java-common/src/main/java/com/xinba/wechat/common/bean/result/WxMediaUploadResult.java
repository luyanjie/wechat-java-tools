package com.xinba.wechat.common.bean.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 15:22
 */
@Data
public class WxMediaUploadResult implements Serializable {
    private static final long serialVersionUID = 9091617493321352242L;

    private String url;
    private String type;
    private String mediaId;
    private String thumbMediaId;
    private long createdAt;

    public static WxMediaUploadResult fromJson(String json) {
        return JSON.parseObject(json, WxMediaUploadResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
