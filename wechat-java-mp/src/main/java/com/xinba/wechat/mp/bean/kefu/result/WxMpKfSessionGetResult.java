package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpKfSessionGetResult extends AbstractKefuBean implements Serializable {

  private static final long serialVersionUID = -6976525024296825931L;
  /**
   * kf_account 正在接待的客服，为空表示没有人在接待
   */
  @JSONField(name = "kf_account")
  private String kfAccount;

  /**
   * createtime 会话接入的时间 ，UNIX时间戳
   */
  @JSONField(name = "createtime")
  private long createTime;

  public static WxMpKfSessionGetResult fromJson(String json) {
    return fromJson(json, WxMpKfSessionGetResult.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
