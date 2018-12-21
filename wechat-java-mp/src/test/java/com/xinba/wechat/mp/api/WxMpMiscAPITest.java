package com.xinba.wechat.mp.api;

import com.google.inject.Inject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import org.testng.*;
import org.testng.annotations.*;

import java.util.Arrays;

/**
 * @author chanjarster
 */
@Test(groups = "miscAPI")
@Guice(modules = ApiTestModule.class)
public class WxMpMiscAPITest {

    @Inject
    protected WxMpService wxService;

    @Test
    public void testGetCallbackIP() throws WxErrorException {
        String[] ipArray = this.wxService.getCallbackIP();
        System.out.println(Arrays.toString(ipArray));
        Assert.assertNotNull(ipArray);
        Assert.assertNotEquals(ipArray.length, 0);
    }
}
