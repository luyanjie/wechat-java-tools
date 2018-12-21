package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:06
 */
@Data
public abstract class WxDataCubeBaseResult implements Serializable {

    private static final long serialVersionUID = -3741182119993767426L;
    /**
     * ref_date.
     * 数据的日期，需在begin_date和end_date之间
     */
    @JSONField(name = "ref_date")
    private String refDate;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
