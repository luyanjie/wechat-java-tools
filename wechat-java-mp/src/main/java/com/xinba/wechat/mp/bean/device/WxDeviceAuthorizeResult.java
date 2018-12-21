package com.xinba.wechat.mp.bean.device;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author keungtung.
 * @date 10/12/2016
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceAuthorizeResult extends AbstractDeviceBean {
  private static final long serialVersionUID = 9105294570912249811L;

  private List<BaseResponse> resp;

  public static WxDeviceAuthorizeResult fromJson(String response) {
    return JSON.parseObject(response, WxDeviceAuthorizeResult.class);
  }

}
