package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxMpShakeAroundRelationSearchQuery implements Serializable {
  private static final long serialVersionUID = -301784043026635855L;
  private int type;
  private Integer pageId;
  private Integer begin;
  private Integer count;
  private WxMpDeviceIdentifier deviceIdentifier;
  public String toJsonString(){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("type", type);
   switch (type){
     case 1:
       jsonObject.put("device_identifier", deviceIdentifier.toJsonObject());
       break;
     case 2:
       jsonObject.put("page_id", pageId);
       jsonObject.put("begin", begin);
       jsonObject.put("count", count);
       break;
     default:
       throw new IllegalArgumentException("type error");
   }
   return jsonObject.toString();
  }
}
