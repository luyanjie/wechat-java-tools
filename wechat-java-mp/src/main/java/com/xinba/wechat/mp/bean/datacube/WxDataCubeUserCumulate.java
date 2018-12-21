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
 * @date 2018/12/18 11:28
 *
 * 累计用户数据接口的返回JSON数据包
 */
@Data
public class WxDataCubeUserCumulate implements Serializable {

    private static final long serialVersionUID = -3570981300225093657L;

    private Date refDate;

    private Integer cumulateUser;

    public static List<WxDataCubeUserCumulate> fromJson(String json) {
        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),
                new TypeReference<List<WxDataCubeUserCumulate>>(){});
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
