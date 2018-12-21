package com.xinba.wechat.mp.bean.membercard;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * <pre>
 * 拉取会员信息返回的结果
 *
 * 字段格式参考https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1451025283  6.2.1小节的步骤5
 * </pre>
 *
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class WxMpMemberCardUserInfoResult implements Serializable {


  private static final long serialVersionUID = 5286847290141069392L;
  private String errorCode;

  private String errorMsg;

  private String openId;

  private String nickname;

  private String membershipNumber;

  private Integer bonus;

  private Double balance;

  private String sex;

  private MemberCardUserInfo userInfo;

  private String userCardStatus;

  private Boolean hasActive;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static WxMpMemberCardUserInfoResult fromJson(String json) {
    return JSON.parseObject(json, WxMpMemberCardUserInfoResult.class);
  }
}

