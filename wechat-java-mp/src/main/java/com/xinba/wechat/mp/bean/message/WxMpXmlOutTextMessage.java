package com.xinba.wechat.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.util.xml.XStreamCDataConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 * */
@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxMpXmlOutTextMessage extends WxMpXmlOutMessage {
  private static final long serialVersionUID = -3972786455288763361L;

  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String content;

  public WxMpXmlOutTextMessage() {
    this.msgType = WxConstant.XmlMsgType.TEXT;
  }

}
