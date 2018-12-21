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
public class WxMpKfSessionWaitCaseList extends AbstractKefuBean implements Serializable {

  private static final long serialVersionUID = -8663773402519183390L;
  /**
   * count 未接入会话数量
   */
  @JSONField(name = "count")
  private Long count;

  /**
   * waitcaselist 未接入会话列表，最多返回100条数据
   */
  @JSONField(name = "waitcaselist")
  private List<WxMpKfSession> kfSessionWaitCaseList;

  public static WxMpKfSessionWaitCaseList fromJson(String json) {
    return fromJson(json,
      WxMpKfSessionWaitCaseList.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
