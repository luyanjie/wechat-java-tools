package com.xinba.wechat.common.error;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WxErrorTest {

  @Test
  public void testFromJson() {
    String json = "{ \"errcode\": 40003, \"errmsg\": \"invalid openid\" }";
    WxError wxError = WxError.fromJson(json);
    assertEquals(40003, wxError.getErrorCode());
    assertEquals(wxError.getErrorMsg(), "invalid openid");

  }

  @Test
  public void testFromBadJson1() {
    String json = "{ \"errcode\": 40003, \"errmsg\": \"invalid openid\", \"media_id\": \"12323423dsfafsf232f\" }";
    WxError wxError = WxError.fromJson(json);
    assertEquals(40003, wxError.getErrorCode());
    assertEquals(wxError.getErrorMsg(), "invalid openid");

  }

  @Test
  public void testFromBadJson2() {
    String json = "{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}";
    WxError wxError = WxError.fromJson(json);
    assertEquals(0, wxError.getErrorCode());
    assertEquals(wxError.getErrorMsg(), null);

  }

}
