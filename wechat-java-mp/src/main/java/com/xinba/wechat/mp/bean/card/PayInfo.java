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
 * 支付功能
 */
@Data
public class PayInfo implements Serializable {

    /**
     * 刷卡功能
     */
    @JSONField(name = "swipe_card")
    private SwipeCard swipeCard;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
