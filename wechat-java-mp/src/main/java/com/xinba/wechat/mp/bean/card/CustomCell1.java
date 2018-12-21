package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:18
 *
 * 自定义会员信息类目
 */
@Data
public class CustomCell1 implements Serializable {
    private static final long serialVersionUID = 4468765290876982473L;

    /**
     * 入口名称
     */
    private String name;

    /**
     * 入口右侧提示语,6个汉字内。
     */
    private String tips;

    /**
     * 入口跳转链接。
     */
    private String url;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
