package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import com.xinba.wechat.common.api.WxConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/17 17:56
 * <p>
 * openid 列表群发的消息
 */
@Data
public class WxMpMassOpenIdsMessage implements Serializable {
    private static final long serialVersionUID = -245882420436234777L;
    /**
     * openid列表，最多支持10,000个
     */
    private List<String> toUsers = new ArrayList<>();
    /**
     * <pre>
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
    /**
     * 文章被判定为转载时，是否继续进行群发操作。
     */
    private boolean sendIgnoreReprint = false;
    /**
     * 开发者测试群发msgid，长度限制为64字符，如不填，则后台默认以群发范围和群发内容的摘要作为clientmsgid
     */
    private String clientMsgId;

    public WxMpMassOpenIdsMessage() {
        super();
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public void addUser(String openid) {
        if (!this.toUsers.contains(openid)) {
            this.toUsers.add(openid);
        }
    }
}
