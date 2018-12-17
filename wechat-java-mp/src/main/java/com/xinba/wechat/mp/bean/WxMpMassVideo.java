package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:20
 *
 * 群发用到的视频对象
 */
@Data
public class WxMpMassVideo implements Serializable {
    private static final long serialVersionUID = -1321317531922207333L;

    private String mediaId;
    private String title;
    private String description;

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
