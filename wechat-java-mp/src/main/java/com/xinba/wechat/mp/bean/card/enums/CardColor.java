package com.xinba.wechat.mp.bean.card.enums;

/**
 * @author jokin
 * @date 2018/12/18 10:08
 *
 * 会员卡颜色
 */
public enum  CardColor {
    /**
     * 会员卡颜色
     * */
    Color010("#63b359"),
    Color020("#2c9f67"),
    Color030("#509fc9"),
    Color040("#5885cf"),
    Color050("#9062c0"),
    Color060("#d09a45"),
    Color070("#e4b138"),
    Color080("#ee903c"),
    Color081("#f08500"),
    Color082("#a9d92d"),
    Color090("#dd6549"),
    Color100("#cc463d"),
    Color101("#cf3e36"),
    Color102("#5E6671");

    private String type;

    CardColor(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
