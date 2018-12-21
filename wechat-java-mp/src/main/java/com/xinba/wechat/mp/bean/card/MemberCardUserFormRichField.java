package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.card.enums.CardRichFieldType;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 10:33
 *
 * 用户表单富文本信息
 */
@Data
public class MemberCardUserFormRichField implements Serializable {
    private static final long serialVersionUID = 3981946195257093647L;

    /**
     * 富文本类型
     */
    @JSONField(name = "type")
    private CardRichFieldType type;

    private String name;

    @JSONField(name ="values")
    private List<String> valueList;

    public void add(String value) {
        if (valueList == null){
            valueList = new ArrayList<>();}
        valueList.add(value);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
