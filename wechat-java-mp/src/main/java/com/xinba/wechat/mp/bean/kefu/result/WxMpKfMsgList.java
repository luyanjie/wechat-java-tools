package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.Data;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpKfMsgList extends AbstractKefuBean implements Serializable {
  private static final long serialVersionUID = 4524296707435188202L;

  @JSONField(name = "recordlist")
  private List<WxMpKfMsgRecord> records;

  @JSONField(name = "number")
  private Integer number;

  @JSONField(name = "msgid")
  private Long msgId;

  public static WxMpKfMsgList fromJson(String responseContent) {
    return fromJson(responseContent, WxMpKfMsgList.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
