package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:25
 *
 * 接口分析数据接口返回结果对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxDataCubeInterfaceResult extends WxDataCubeBaseResult {
    private static final long serialVersionUID = 1490916545925712311L;
    /**
     * ref_hour
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    @JSONField(name = "ref_hour")
    private Integer refHour;

    /**
     * callback_count
     * 通过服务器配置地址获得消息后，被动回复用户消息的次数
     */
    @JSONField(name = "callback_count")
    private Integer callbackCount;

    /**
     * fail_count
     * 上述动作的失败次数
     */
    @JSONField(name = "fail_count")
    private Integer failCount;

    /**
     * total_time_cost
     * 总耗时，除以callback_count即为平均耗时
     */
    @JSONField(name = "total_time_cost")
    private Integer totalTimeCost;

    /**
     * max_time_cost
     * 最大耗时
     */
    @JSONField(name = "max_time_cost")
    private Integer maxTimeCost;

    public static List<WxDataCubeInterfaceResult> fromJson(String json) {
        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),
                new TypeReference<List<WxDataCubeInterfaceResult>>(){});
    }

}