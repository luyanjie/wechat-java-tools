package com.xinba.wechat.mp.bean.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpOAuth2AccessToken implements Serializable {
  private static final long serialVersionUID = -1345910558078620805L;

  private String accessToken;

  private int expiresIn = -1;

  private String refreshToken;

  private String openId;

  private String scope;

  /**
   * https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&announce_id=11513156443eZYea&version=&lang=zh_CN.
   * 本接口在scope参数为snsapi_base时不再提供unionID字段。
   */
  private String unionId;

  public static WxMpOAuth2AccessToken fromJson(String json) {
    return JSON.parseObject(json, WxMpOAuth2AccessToken.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
