package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:00
 *
 * 封面摘要
 */
@Data
public class Abstract implements Serializable {
    private static final long serialVersionUID = -5360084110254782864L;

    /**
     * 摘要
     */
    @JSONField(name = "abstract")
    private String abstractInfo;

    /**
     * 封面图片列表,仅支持填入一 个封面图片链接， 上传图片接口 上传获取图片获得链接，填写 非CDN链接会报错，并在此填入。 建议图片尺寸像素850*350
     */
    @JSONField(name = "icon_url_list")
    private String iconUrlList;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
