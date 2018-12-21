package com.xinba.wechat.mp.bean.kefu.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 * */
@Data
public class WxMpKfSessionRequest extends AbstractKefuBean implements Serializable {
  private static final long serialVersionUID = -5451863610674856927L;

  /**
   * kf_account 完整客服账号，格式为：账号前缀@公众号微信号
   */
  @JSONField(name = "kf_account")
  private String kfAccount;

  /**
   * openid 客户openid
   */
  @JSONField(name = "openid")
  private String openid;

  public WxMpKfSessionRequest(String kfAccount, String openid) {
    this.kfAccount = kfAccount;
    this.openid = openid;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
