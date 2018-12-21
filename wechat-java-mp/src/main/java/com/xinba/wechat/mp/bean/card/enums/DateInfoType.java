package com.xinba.wechat.mp.bean.card.enums;

/**
 * @author jokin
 * @date 2018/12/18 10:12
 *
 * 卡券使用时限类型
 */
public enum  DateInfoType {
    /**
     * 永久有效类型
     * */
    DATE_TYPE_PERMANENT("永久有效类型"),
    DATE_TYPE_FIX_TIME_RANGE("固定日期"),
    DATE_TYPE_FIX_TERM("固定时长");

    private String description;

    DateInfoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
