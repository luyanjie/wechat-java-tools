package com.xinba.wechat.mp.bean.material;

import lombok.Data;
import java.io.Serializable;

/**
 * @author miller
 */
@Data
public class WxMediaImgUploadResult extends AbstractMediaBean implements Serializable {
  private static final long serialVersionUID = 1996392453428768829L;
  private String url;

  public static WxMediaImgUploadResult fromJson(String json) {
    return fromJson(json, WxMediaImgUploadResult.class);
  }

}
