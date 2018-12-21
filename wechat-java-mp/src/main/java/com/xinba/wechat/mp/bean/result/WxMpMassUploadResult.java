package com.xinba.wechat.mp.bean.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * <pre>
 * 上传群发用的素材的结果.
 * 视频和图文消息需要在群发前上传素材
 * </pre>
 *
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpMassUploadResult implements Serializable {
  private static final long serialVersionUID = 6568157943644994029L;

  private String type;
  private String mediaId;
  private long createdAt;

  public static WxMpMassUploadResult fromJson(String json) {
    return JSON.parseObject(json, WxMpMassUploadResult.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
