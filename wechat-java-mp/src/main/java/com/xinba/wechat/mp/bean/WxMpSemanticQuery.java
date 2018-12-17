package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:22
 *
 * 语义理解查询对象
 */
@Data
public class WxMpSemanticQuery implements Serializable {
    private static final long serialVersionUID = -2405882954748978492L;

    private String query;
    private String category;
    private Float latitude;
    private Float longitude;
    private String city;
    private String region;
    private String appid;
    private String uid;

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
