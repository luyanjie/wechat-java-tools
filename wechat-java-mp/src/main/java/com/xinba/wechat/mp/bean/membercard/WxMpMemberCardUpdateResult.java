package com.xinba.wechat.mp.bean.membercard;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * <pre>
 * 用于 `7 更新会员信息` 的接口调用后的返回结果
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1451025283
 * </pre>
 *
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class WxMpMemberCardUpdateResult implements Serializable {

  private static final long serialVersionUID = 9084886191442098311L;

  private String errorCode;

  private String errorMsg;

  private String openId;

  private Integer resultBonus;

  private Double resultBalance;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static WxMpMemberCardUpdateResult fromJson(String json) {
    return JSON.parseObject(json, WxMpMemberCardUpdateResult.class);
  }
}
