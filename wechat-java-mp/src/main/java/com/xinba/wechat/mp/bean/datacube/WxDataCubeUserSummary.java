package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:29
 *
 * 用户增减数据接口的返回JSON数据
 *
 * 详情查看文档：<a href="http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141082&token=&lang=zh_CN">用户分析数据接口</a>
 */
@Data
public class WxDataCubeUserSummary implements Serializable {
    private static final long serialVersionUID = -2336654489906694173L;

    private Date refDate;

    private Integer userSource;

    private Integer newUser;

    private Integer cancelUser;

    public static List<WxDataCubeUserSummary> fromJson(String json) {
        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),
                new TypeReference<List<WxDataCubeUserSummary>>(){});
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
