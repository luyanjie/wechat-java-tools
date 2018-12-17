package com.xinba.wechat.common.bean.menu;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/17 14:56
 * 菜单（公众号和企业号共用的）.
 */
@Data
public class WxMenu implements Serializable {
    private static final long serialVersionUID = 7753384918039796216L;


    private List<WxMenuButton> buttons = new ArrayList<>();

    private WxMenuRule matchRule;

    /**
     * 要用 http://mp.weixin.qq.com/wiki/16/ff9b7b85220e1396ffa16794a9d95adc.html 格式来反序列化
     * 相比 http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html 的格式，外层多套了一个menu
     */
    public static WxMenu fromJson(String json) {

        return JSON.parseObject(json, WxMenu.class);
    }

    /**
     * 要用 http://mp.weixin.qq.com/wiki/16/ff9b7b85220e1396ffa16794a9d95adc.html 格式来反序列化
     * 相比 http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html 的格式，外层多套了一个menu
     */
    public static WxMenu fromJson(InputStream is) {
        try {
            return JSON.parseObject(is, Charset.forName("UTF-8"),WxMenu.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new WxMenu();
        /*return WxGsonBuilder.create()
                .fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), WxMenu.class);*/
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
