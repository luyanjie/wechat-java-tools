package com.xinba.wechat.mp.bean.tag;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 *  用户标签对象
 *
 * @author jokin
 * @date 2018-12-18
 */
@Data
public class WxUserTag implements Serializable {
  private static final long serialVersionUID = -7722428695667031252L;

  /**
   * 标签id，由微信分配.
   */
  private Long id;

  /**
   * 标签名，UTF8编码.
   */
  private String name;

  /**
   * 此标签下粉丝数.
   */
  private Integer count;

  public static WxUserTag fromJson(String json) {

    return JSON.parseObject(JSON.parseObject(json).get("tag").toString(),WxUserTag.class);
  }

  public static List<WxUserTag> listFromJson(String json) {
    return JSON.parseObject(JSON.parseObject(json).get("tags").toString(),new TypeReference<List<WxUserTag>>(){});
  }

  public String toJson() {
    return JSON.toJSONString(this);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
