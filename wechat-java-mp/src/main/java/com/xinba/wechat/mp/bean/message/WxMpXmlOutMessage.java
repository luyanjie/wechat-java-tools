package com.xinba.wechat.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xinba.wechat.common.util.xml.XStreamCDataConverter;
import com.xinba.wechat.mp.api.WxMpConfigStorage;
import com.xinba.wechat.mp.builder.outxml.*;
import com.xinba.wechat.mp.util.crypto.WxMpCryptUtil;
import com.xinba.wechat.mp.util.xml.XStreamTransformer;
import lombok.Data;

import java.io.Serializable;

@XStreamAlias("xml")
@Data
public abstract class WxMpXmlOutMessage implements Serializable {
  private static final long serialVersionUID = -381382011286216263L;

  @XStreamAlias("ToUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String toUserName;

  @XStreamAlias("FromUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String fromUserName;

  @XStreamAlias("CreateTime")
  protected Long createTime;

  @XStreamAlias("MsgType")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String msgType;

  /**
   * 获得文本消息builder
   */
  public static TextBuilder TEXT() {
    return new TextBuilder();
  }

  /**
   * 获得图片消息builder
   */
  public static ImageBuilder IMAGE() {
    return new ImageBuilder();
  }

  /**
   * 获得语音消息builder
   */
  public static VoiceBuilder VOICE() {
    return new VoiceBuilder();
  }

  /**
   * 获得视频消息builder
   */
  public static VideoBuilder VIDEO() {
    return new VideoBuilder();
  }

  /**
   * 获得音乐消息builder
   */
  public static MusicBuilder MUSIC() {
    return new MusicBuilder();
  }

  /**
   * 获得图文消息builder
   */
  public static NewsBuilder NEWS() {
    return new NewsBuilder();
  }

  /**
   * 获得客服消息builder
   */
  public static TransferCustomerServiceBuilder TRANSFER_CUSTOMER_SERVICE() {
    return new TransferCustomerServiceBuilder();
  }

  @SuppressWarnings("unchecked")
  public String toXml() {
    return XStreamTransformer.toXml((Class<WxMpXmlOutMessage>) this.getClass(), this);
  }

  /**
   * 转换成加密的xml格式
   */
  public String toEncryptedXml(WxMpConfigStorage wxMpConfigStorage) {
    String plainXml = toXml();
    WxMpCryptUtil pc = new WxMpCryptUtil(wxMpConfigStorage);
    return pc.encrypt(plainXml);
  }
}
