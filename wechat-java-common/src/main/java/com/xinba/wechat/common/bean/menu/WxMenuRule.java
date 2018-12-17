package com.xinba.wechat.common.bean.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 15:18
 */
@Data
public class WxMenuRule implements Serializable {
    private static final long serialVersionUID = 3825539625111491741L;

    /**
     * 变态的微信接口，反序列化时这里反人类的使用和序列化时不一样的名字.
     */
    @JSONField(name = "tag_id",alternateNames = "group_id")
    private String tagId;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String clientPlatformType;
    private String language;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
