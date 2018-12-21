package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:37
 *
 * 图文列表
 */
@Data
public class TextImageList implements Serializable {

    private static final long serialVersionUID = 884485034331129132L;
    /**
     * 图片链接,必须调用 上传图片接口 上传图片获得链接，并在此填入， 否则报错
     */
    @JSONField(name = "image_url")
    private String imageUrl;

    /**
     * 图文描述
     */
    private String text;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
