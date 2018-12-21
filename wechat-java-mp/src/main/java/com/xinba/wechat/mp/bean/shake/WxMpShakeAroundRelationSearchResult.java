package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WxMpShakeAroundRelationSearchResult implements Serializable {
    private static final long serialVersionUID = -8867509553840376805L;
    private Integer errcode;
    private String errmsg;
    private WxMpShakeAcoundRelationSearch data;

    public static WxMpShakeAroundRelationSearchResult fromJson(String json) {
        return JSON.parseObject(json, WxMpShakeAroundRelationSearchResult.class);
    }

    @Data
    public static class WxMpShakeAcoundRelationSearch implements Serializable {
        private static final long serialVersionUID = 973442079568612503L;
        private List<WxMpDeviceIdentifier> relations;
        private Integer total_count;
    }
}
