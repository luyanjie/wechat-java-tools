package com.xinba.wechat.mp.bean.card.enums;

/**
 * @author jokin
 * @date 2018/12/18 10:09
 *
 * 微信卡券激活字段
 */
public enum  CardFieldType {
    /**
     * 微信选项
     * */
    COMMON_FIELD("微信选项"),
    CUSTOM_FIELD("自定义选项"),
    RICH_FIELD("自定义富文本类型");

    private String description;

    CardFieldType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
