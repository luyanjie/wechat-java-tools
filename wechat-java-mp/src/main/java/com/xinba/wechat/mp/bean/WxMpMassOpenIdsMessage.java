package com.xinba.wechat.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/17 17:56
 *
 * openid 列表群发的消息
 */
@Data
public class WxMpMassOpenIdsMessage implements Serializable {
    private static final long serialVersionUID = -245882420436234777L;
    /**
     * openid列表，最多支持10,000个
     * */
    private List<String> toUsers = new ArrayList<>();
    /**
     * <pre>
     * 请使用
     * {@link WxConsts.MassMsgType#IMAGE}
     * {@link WxConsts.MassMsgType#MPNEWS}
     * {@link WxConsts.MassMsgType#TEXT}
     * {@link WxConsts.MassMsgType#MPVIDEO}
     * {@link WxConsts.MassMsgType#VOICE}
     * 如果msgtype和media_id不匹配的话，会返回系统繁忙的错误
     * </pre>
     */
    private String msgType;
}
