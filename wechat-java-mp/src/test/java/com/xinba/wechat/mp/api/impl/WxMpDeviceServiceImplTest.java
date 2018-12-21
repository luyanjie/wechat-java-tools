package com.xinba.wechat.mp.api.impl;


import com.google.inject.Inject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.bean.device.WxDeviceQrCodeResult;
import org.testng.annotations.*;

/**
 * Created by keungtung on 14/12/2016.
 */
@Test(groups = "deviceApi")
@Guice(modules = ApiTestModule.class)
public class WxMpDeviceServiceImplTest {
    @Inject
    protected WxMpService wxService;

    @Test(dataProvider = "productId")
    public void testGetQrcode(String productId) {
        try {
            WxDeviceQrCodeResult result = wxService.getDeviceService().getQrCode(productId);
            println(result.toJson());
        } catch (WxErrorException e) {
            println(e.getMessage());
        }
    }

    private void println(String content) {
        System.out.println(content);
    }

    @DataProvider(name = "productId")
    public Object[][] getProductId() {
        return new Object[][]{new Object[]{"25639"}};
    }
}
