package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:36
 *
 * 刷卡功能
 */
@Data
public class SwipeCard implements Serializable {

    private static final long serialVersionUID = -6169267567168036913L;
    /**
     * 是否设置该会员卡支持拉出微信支付刷卡界面
     */
    @JSONField(name = "is_swipe_card")
    private boolean isSwipeCard;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
