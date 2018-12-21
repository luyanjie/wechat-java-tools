package com.xinba.wechat.mp.bean.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 模板列表信息
 *
 * @author jokin
 * @date 2018-12-18
 */
@Data
public class WxMpTemplate implements Serializable {
  private static final long serialVersionUID = -7366474522571199372L;

  /**
   * template_id.
   * 模板ID
   */
  @JSONField(name = "template_id")
  private String templateId;
  /**
   * title.
   * 模板标题
   */
  @JSONField(name = "title")
  private String title;
  /**
   * primary_industry.
   * 模板所属行业的一级行业
   */
  @JSONField(name = "primary_industry")
  private String primaryIndustry;
  /**
   * deputy_industry.
   * 模板所属行业的二级行业
   */
  @JSONField(name = "deputy_industry")
  private String deputyIndustry;
  /**
   * content.
   * 模板内容
   */
  @JSONField(name = "content")
  private String content;
  /**
   * example.
   * 模板示例
   */
  @JSONField(name = "example")
  private String example;

  public static List<WxMpTemplate> fromJson(String json) {

    return JSON.parseObject(JSON.parseObject(json).get("template_list").toString(),new TypeReference<List<WxMpTemplate>>(){});

  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
