package com.xinba.wechat.mp;

import lombok.Getter;

/**
 * @author jokin
 * @date 2018/12/17 17:38
 *
 * AI开放接口里的语言类型，目前只支持两种：中文和英文
 */
@Getter
public enum AiLangType {
    /**
     * 中文 汉语
     */
    zh_CN("zh_CH"),
    /**
     * 英文 英语
     */
    en_US("en_US");

    private String code;

    AiLangType(String code){
        this.code = code;
    }
}
