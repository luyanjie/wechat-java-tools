package com.xinba.wechat.mp.api.impl;

import com.google.inject.Inject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.bean.wifi.WxMpWifiShopListResult;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/10.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMpWifiServiceImplTest {
  @Inject
  private WxMpService wxService;

  @Test
  public void testListShop() throws WxErrorException {
    final WxMpWifiShopListResult result = this.wxService.getWifiService().listShop(1, 2);

    Assert.assertTrue(false,"");
    System.out.println(result);
  }
}
