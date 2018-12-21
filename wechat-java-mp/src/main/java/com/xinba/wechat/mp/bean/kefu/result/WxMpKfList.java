package com.xinba.wechat.mp.bean.kefu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.kefu.AbstractKefuBean;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpKfList extends AbstractKefuBean implements Serializable {
  private static final long serialVersionUID = -8194193505173564894L;

  @JSONField(name = "kf_list")
  private List<WxMpKfInfo> kfList;

  public static WxMpKfList fromJson(String json) {
    return fromJson(json, WxMpKfList.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
