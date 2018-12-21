package com.xinba.wechat.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.util.xml.XStreamCDataConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 * */

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxMpXmlOutTransferKefuMessage extends WxMpXmlOutMessage {
  private static final long serialVersionUID = 1850903037285841322L;

  @XStreamAlias("TransInfo")
  protected TransInfo transInfo;

  public WxMpXmlOutTransferKefuMessage() {
    this.msgType = WxConstant.KefuMsgType.TRANSFER_CUSTOMER_SERVICE;
  }

  @XStreamAlias("TransInfo")
  @Data
  public static class TransInfo implements Serializable {
    private static final long serialVersionUID = -6317885617135706056L;

    @XStreamAlias("KfAccount")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String kfAccount;

  }
}
