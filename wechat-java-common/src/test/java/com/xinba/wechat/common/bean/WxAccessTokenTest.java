package com.xinba.wechat.common.bean;

import org.junit.Assert;
import org.junit.Test;

public class WxAccessTokenTest {

  @Test
  public void testFromJson() {

    String json = "{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}";
    WxAccessToken wxError = WxAccessToken.fromJson(json);
    Assert.assertEquals(wxError.getAccessToken(), "ACCESS_TOKEN");
    Assert.assertTrue(wxError.getExpiresIn() == 7200);

  }

}
