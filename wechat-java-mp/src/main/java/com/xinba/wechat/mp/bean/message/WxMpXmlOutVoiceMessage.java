package com.xinba.wechat.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.util.xml.XStreamMediaIdConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 * */

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxMpXmlOutVoiceMessage extends WxMpXmlOutMessage {
  private static final long serialVersionUID = 240367390249860551L;

  @XStreamAlias("Voice")
  @XStreamConverter(value = XStreamMediaIdConverter.class)
  private String mediaId;

  public WxMpXmlOutVoiceMessage() {
    this.msgType = WxConstant.XmlMsgType.VOICE;
  }

}
