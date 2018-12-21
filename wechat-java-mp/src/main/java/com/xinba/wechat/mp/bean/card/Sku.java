package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:35
 *
 * 商品信息
 */
@Data
public class Sku implements Serializable {

    private static final long serialVersionUID = 4710236034764916192L;
    /**
     * 卡券库存的数量,不支持填写0，上限为100000000。
     */
    @JSONField(name = "quantity")
    private Integer quantity = 100000000;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

