package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpKfMsgRecord implements Serializable {
  private static final long serialVersionUID = -280692188908528688L;

  /**
   * worker	完整客服帐号，格式为：帐号前缀@公众号微信号
   */
  @JSONField(name = "worker")
  private String worker;

  /**
   * openid	用户标识
   */
  @JSONField(name = "openid")
  private String openid;

  /**
   * opercode	操作码，2002（客服发送信息），2003（客服接收消息）
   */
  @JSONField(name = "opercode")
  private Integer operateCode;

  /**
   * text	聊天记录
   */
  @JSONField(name = "text")
  private String text;

  /**
   * time	操作时间，unix时间戳
   */
  @JSONField(name = "time")
  private Long time;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
