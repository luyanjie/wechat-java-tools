package com.xinba.wechat.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xinba.wechat.common.util.xml.XStreamCDataConverter;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@XStreamAlias("SendLocationInfo")
@Data
public class SendLocationInfo implements Serializable {
  private static final long serialVersionUID = 6633214140499161130L;

  @XStreamAlias("Location_X")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String locationX;

  @XStreamAlias("Location_Y")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String locationY;

  @XStreamAlias("Scale")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String scale;

  @XStreamAlias("Label")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String label;

  @XStreamAlias("Poiname")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String poiName;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
