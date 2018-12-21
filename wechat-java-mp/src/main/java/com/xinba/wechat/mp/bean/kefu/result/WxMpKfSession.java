package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpKfSession implements Serializable {

  private static final long serialVersionUID = -4309707274794973595L;
  /**
   * kf_account 正在接待的客服，为空表示没有人在接待
   */
  @JSONField(name = "kf_account")
  private String kfAccount;

  /**
   * createtime 会话接入的时间，UNIX时间戳
   * 该返回值 存在于 获取客服会话列表接口
   */
  @JSONField(name = "createtime")
  private long createTime;

  /**
   * latest_time 粉丝的最后一条消息的时间，UNIX时间戳
   * 该返回值 存在于 获取未接入会话列表接口
   */
  @JSONField(name = "latest_time")
  private long latestTime;

  /**
   * openid 客户openid
   */
  @JSONField(name = "openid")
  private String openid;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
