package com.xinba.wechat.mp.api.impl;

import com.google.inject.Inject;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.bean.WxMpShakeInfoResult;
import com.xinba.wechat.mp.bean.WxMpShakeQuery;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * 测试摇一摇周边相关的接口
 *
 * @author rememberber
 */
@Test(groups = "userAPI")
@Guice(modules = ApiTestModule.class)
public class WxMpShakeServiceImplTest {
    @Inject
    private WxMpService wxService;

    public void testGetShakeInfo() throws Exception {
        WxMpShakeQuery wxMpShakeQuery = new WxMpShakeQuery();
        wxMpShakeQuery.setTicket("b87db7df490e5cbe4f598272f77f46be");
        wxMpShakeQuery.setNeedPoi(1);
        WxMpShakeInfoResult wxMpShakeInfoResult = this.wxService.getShakeService().getShakeInfo(wxMpShakeQuery);

        System.out.println();
    }

}
