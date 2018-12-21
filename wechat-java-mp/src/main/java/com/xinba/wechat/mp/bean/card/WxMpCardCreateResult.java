package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:40
 *
 * 卡创建返回信息
 */
@Data
public class WxMpCardCreateResult implements Serializable {
    private static final long serialVersionUID = 2379517032131555536L;
    @JSONField(name = "card_id")
    private String cardId;
    private Integer errcode;
    private String errmsg;

    public boolean isSuccess() {
        return 0 == errcode;
    }

    public static WxMpCardCreateResult fromJson(String json) {
        return JSON.parseObject(json, WxMpCardCreateResult.class);
    }

    public static WxMpCardCreateResult failure(String errmsg) {
        WxMpCardCreateResult result = new WxMpCardCreateResult();
        result.setErrcode(500);
        result.setErrmsg(errmsg);
        return result;
    }

    public static WxMpCardCreateResult success() {
        WxMpCardCreateResult result = new WxMpCardCreateResult();
        result.setErrcode(0);
        result.setErrmsg("ok");
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}