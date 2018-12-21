package com.xinba.wechat.mp.bean.membercard;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.card.MemberCardCreateRequest;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public final class WxMpMemberCardCreateMessage  implements Serializable {

  private static final long serialVersionUID = -1757800686815314753L;
  @JSONField(name = "card")
  private MemberCardCreateRequest cardCreateRequest;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static WxMpMemberCardCreateMessage fromJson(String json) {
    return JSON.parseObject(json, WxMpMemberCardCreateMessage.class);
  }
}
