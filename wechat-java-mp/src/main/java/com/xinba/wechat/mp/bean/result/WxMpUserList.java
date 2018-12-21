package com.xinba.wechat.mp.bean.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 关注者列表
 *
 * @author jokin
 * @date 2018/12/18 11:52
 */
@Data
public class WxMpUserList implements Serializable {
  private static final long serialVersionUID = 1389073042674901032L;

  protected long total = -1;
  protected int count = -1;
  protected List<String> openids = new ArrayList<>();
  protected String nextOpenid;

  public static WxMpUserList fromJson(String json) {
    return JSON.parseObject(json, WxMpUserList.class);
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
