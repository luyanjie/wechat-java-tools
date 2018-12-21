package com.xinba.wechat.mp.api;

import com.google.inject.Inject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import org.apache.commons.lang3.StringUtils;
import org.testng.*;
import org.testng.annotations.*;

/**
 * 基础API测试
 *
 * @author chanjarster
 */
@Test(groups = "baseAPI")
@Guice(modules = ApiTestModule.class)
public class WxMpBaseAPITest {

  @Inject
  protected WxMpService wxService;

  public void testRefreshAccessToken() throws WxErrorException {
    WxMpConfigStorage configStorage = this.wxService.getWxMpConfigStorage();
    String before = configStorage.getAccessToken();
    this.wxService.getAccessToken(false);

    String after = configStorage.getAccessToken();
    Assert.assertNotEquals(before, after);
    Assert.assertTrue(StringUtils.isNotBlank(after));
  }

  public void testJsapiTicket() throws WxErrorException {
    String jsapiTicket = this.wxService.getJsapiTicket(false);
    System.out.println(jsapiTicket);
    Assert.assertNotNull(jsapiTicket);
  }

}
