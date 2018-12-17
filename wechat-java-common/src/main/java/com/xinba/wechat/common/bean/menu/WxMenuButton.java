package com.xinba.wechat.common.bean.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/17 14:58
 *
 * 菜单按钮
 */
@Data
public class WxMenuButton implements Serializable {
    private static final long serialVersionUID = -8630306253979178521L;

    /**
     * 菜单响应的动作类型
     * view 表示网页类型
     * click表示点击类型，
     * miniprogram表示小程序类型
     * */
    private String type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节.
     */
    private String name;

    /**
     * <pre>
     * 菜单KEY值，用于消息接口推送，不超过128字节.
     * click等点击类型必须
     * </pre>
     */
    private String key;

    /**
     * <pre>
     * 网页链接.
     * 用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * view、miniprogram类型必须
     * </pre>
     */
    private String url;

    /**
     * <pre>
     * 调用新增永久素材接口返回的合法media_id.
     * media_id类型和view_limited类型必须
     * </pre>
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * <pre>
     * 小程序的appid.
     * miniprogram类型必须
     * </pre>
     */
    @JSONField(name ="appid")
    private String appId;

    /**
     * 小程序的页面路径.
     * miniprogram类型必须
     * */
    @JSONField(name ="pagepath")
    private String pagePath;

    @JSONField(name ="sub_button")
    private List<WxMenuButton> subButtons = new ArrayList<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
