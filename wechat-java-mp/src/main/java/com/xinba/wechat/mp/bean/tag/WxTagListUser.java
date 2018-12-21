package com.xinba.wechat.mp.bean.tag;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 获取标签下粉丝列表的结果对象
 *
 * @author jokin
 * @date 2018-12-18
 */
@Data
public class WxTagListUser implements Serializable {
    private static final long serialVersionUID = -4551768374200676112L;

    /**
     * "count":2,这次获取的粉丝数量.
     */
    @JSONField(name = "count")
    private Integer count;
    /**
     * "data" 粉丝列表.
     */
    @JSONField(name = "data")
    private WxTagListUserData data;
    /**
     * "next_openid" 拉取列表最后一个用户的openid.
     */
    @JSONField(name = "next_openid")
    private String nextOpenid;

    public static WxTagListUser fromJson(String json) {
        return JSON.parseObject(json, WxTagListUser.class);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @Data
    public static class WxTagListUserData implements Serializable {
        private static final long serialVersionUID = -8584537400336245701L;

        /**
         * openid 列表.
         */
        @JSONField(name = "openid")
        private List<String> openidList;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }
}
