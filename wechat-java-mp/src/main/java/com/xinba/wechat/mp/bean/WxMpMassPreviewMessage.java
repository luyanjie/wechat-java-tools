package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import com.xinba.wechat.common.api.WxConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:14
 */
@Data
public class WxMpMassPreviewMessage implements Serializable {
    private static final long serialVersionUID = -1729606284897142143L;

    private String toWxUserName;
    private String toWxUserOpenid;
    /**
     * <pre>
     * 消息类型
     * 请使用
     * {@link WxConstant.MassMsgType#IMAGE}
     * {@link WxConstant.MassMsgType#MPNEWS}
     * {@link WxConstant.MassMsgType#TEXT}
     * {@link WxConstant.MassMsgType#MPVIDEO}
     * {@link WxConstant.MassMsgType#VOICE}
     * 如果msgtype和media_id不匹配的话，会返回系统繁忙的错误
     * </pre>
     */
    private String msgType;
    private String content;
    private String mediaId;

    public WxMpMassPreviewMessage() {
        super();
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
