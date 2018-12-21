package com.xinba.wechat.mp.bean.card.enums;

/**
 * @author jokin
 * @date 2018/12/18 10:10
 *
 * 会员卡富文本字段类型
 */
public enum  CardRichFieldType {
    /**
     * 自定义单选
     * */
    FORM_FIELD_RADIO("自定义单选"),
    FORM_FIELD_SELECT("自定义选择项"),
    FORM_FIELD_CHECK_BOX("自定义多选");

    private String description;

    CardRichFieldType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
