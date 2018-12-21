package com.xinba.wechat.mp.bean.material;

import lombok.Data;
import java.io.Serializable;

@Data
public class WxMpMaterialVideoInfoResult extends AbstractMediaBean implements Serializable {
  private static final long serialVersionUID = 1269131745333792202L;

  private String title;
  private String description;
  private String downUrl;

  public static WxMpMaterialVideoInfoResult fromJson(String json) {
    return fromJson(json, WxMpMaterialVideoInfoResult.class);
  }

}
