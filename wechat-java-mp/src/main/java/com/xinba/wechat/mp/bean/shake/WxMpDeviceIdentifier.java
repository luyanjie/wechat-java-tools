package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018-12-18
 *
 * 设备识别
 * */

@Data
public class WxMpDeviceIdentifier implements Serializable {
  private static final long serialVersionUID = 2287714042568736338L;

  private Integer device_id;
  private String uuid;
  private Integer page_id;
  private Integer major;
  private Integer minor;
  public JSONObject toJsonObject(){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("device_id", device_id);
    jsonObject.put("uuid", uuid);
    jsonObject.put("major", major);
    jsonObject.put("minor", minor);
    return jsonObject;
  }
}
