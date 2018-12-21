package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMpKfSessionList extends AbstractKefuBean implements Serializable {

  private static final long serialVersionUID = -5361241727899159792L;
  /**
   * 会话列表
   */
  @JSONField(name = "sessionlist")
  private List<WxMpKfSession> kfSessionList;

  public static WxMpKfSessionList fromJson(String json) {
    return fromJson(json,
      WxMpKfSessionList.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
