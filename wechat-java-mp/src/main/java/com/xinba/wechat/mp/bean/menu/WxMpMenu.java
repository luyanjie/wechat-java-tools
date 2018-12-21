package com.xinba.wechat.mp.bean.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.common.bean.menu.WxMenuButton;
import com.xinba.wechat.common.bean.menu.WxMenuRule;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 公众号专用的菜单类，可能包含个性化菜单
 *
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class WxMpMenu implements Serializable {
    private static final long serialVersionUID = -5794350513426702252L;

    @JSONField(name = "menu")
    private WxMpConditionalMenu menu;

    @JSONField(name = "conditionalmenu")
    private List<WxMpConditionalMenu> conditionalMenu;

    public static WxMpMenu fromJson(String json) {
        return JSON.parseObject(json, WxMpMenu.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Data
    public static class WxMpConditionalMenu implements Serializable {
        private static final long serialVersionUID = -2279946921755382289L;

        @JSONField(name = "button")
        private List<WxMenuButton> buttons;
        @JSONField(name = "matchrule")
        private WxMenuRule rule;
        @JSONField(name = "menuid")
        private String menuId;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }

    }

}
