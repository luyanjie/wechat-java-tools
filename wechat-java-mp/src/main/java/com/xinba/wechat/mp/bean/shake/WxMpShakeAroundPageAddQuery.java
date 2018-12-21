package com.xinba.wechat.mp.bean.shake;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;


/**
 * @author jokin
 * @date 2018-12-18
 *
 * */

@Data
public class WxMpShakeAroundPageAddQuery implements Serializable {
  private static final long serialVersionUID = -5743532945360640998L;
  private String title;
  private String description;
  private String pageUrl;
  private String comment;
  private String iconUrl;
  public String toJsonString(){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("title", title);
    jsonObject.put("description", description);
    jsonObject.put("page_url", pageUrl);
    jsonObject.put("comment", comment);
    jsonObject.put("icon_url", iconUrl);
    return jsonObject.toString();
  }
}
