package com.xinba.wechat.mp.bean.store;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 门店列表结果类
 * @author jokin
 * @date 2018-12-18
 */
@Data
public class WxMpStoreListResult implements Serializable {
  private static final long serialVersionUID = 5388907559949538663L;

  /**
   * 错误码，0为正常.
   */
  @JSONField(name = "errcode")
  private Integer errCode;
  /**
   * 错误信息.
   */
  @JSONField(name = "errmsg")
  private String errMsg;
  /**
   * 门店信息列表.
   */
  @JSONField(name = "business_list")
  private List<WxMpStoreInfo> businessList;
  /**
   * 门店信息总数.
   */
  @JSONField(name = "total_count")
  private Integer totalCount;

  public static WxMpStoreListResult fromJson(String json) {
    return JSON.parseObject(json, WxMpStoreListResult.class);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
