package com.xinba.wechat.mp.bean.card.enums;

/**
 * @author jokin
 * @date 2018/12/18 10:12
 *
 * 卡券激活类型
 */
public enum  CardWechatFieldType {
    /**
     * 手机号
     * */
    USER_FORM_INFO_FLAG_MOBILE("手机号"),
    USER_FORM_INFO_FLAG_SEX("性别"),
    USER_FORM_INFO_FLAG_NAME("姓名"),
    USER_FORM_INFO_FLAG_BIRTHDAY("生日"),
    USER_FORM_INFO_FLAG_IDCARD("身份证"),
    USER_FORM_INFO_FLAG_EMAIL("邮箱"),
    USER_FORM_INFO_FLAG_LOCATION("详细地址"),
    USER_FORM_INFO_FLAG_EDUCATION_BACKGRO("教育背景"),
    USER_FORM_INFO_FLAG_INDUSTRY("行业"),
    USER_FORM_INFO_FLAG_INCOME("收入"),
    USER_FORM_INFO_FLAG_HABIT("兴趣爱好");

    private String description;

    CardWechatFieldType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
