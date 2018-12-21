package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:43
 *
 * 卡券初始页面返回信息
 */
@Data
public class WxMpCardLandingPageCreateResult implements Serializable {
    private Integer errcode;
    private String errmsg;

    /**
     * 货架链接。
     */
    private String url;
    /**
     * 货架ID。货架的唯一标识
     */
    @JSONField(name = "page_id")
    private Integer pageId;

    public boolean isSuccess() {
        return 0 == errcode;
    }

    public static WxMpCardLandingPageCreateResult fromJson(String json) {
        return JSON.parseObject(json, WxMpCardLandingPageCreateResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}

