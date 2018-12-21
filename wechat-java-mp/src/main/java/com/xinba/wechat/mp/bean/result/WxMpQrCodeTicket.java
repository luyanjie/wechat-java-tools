package com.xinba.wechat.mp.bean.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * 换取二维码的Ticket
 *
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpQrCodeTicket implements Serializable {
  private static final long serialVersionUID = 5777119669111011584L;

  protected String ticket;
  /**
   * 如果为-1，说明是永久
   */
  protected int expireSeconds = -1;
  protected String url;

  public static WxMpQrCodeTicket fromJson(String json) {
    return JSON.parseObject(json, WxMpQrCodeTicket.class);
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
