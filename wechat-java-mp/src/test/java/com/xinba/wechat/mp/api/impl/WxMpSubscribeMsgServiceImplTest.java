package com.xinba.wechat.mp.api.impl;

import com.google.inject.Inject;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.api.test.TestConfigStorage;
import com.xinba.wechat.mp.bean.subscribe.WxMpSubscribeMessage;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * @author Mklaus
 * @date 2018-01-22 下午2:02
 */
@Guice(modules = ApiTestModule.class)
public class WxMpSubscribeMsgServiceImplTest {

    @Inject
    protected WxMpService wxService;

    @Test
    public void testSendSubscribeMessage() throws WxErrorException {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService
                .getWxMpConfigStorage();

        WxMpSubscribeMessage message = WxMpSubscribeMessage.builder()
                .title("weixin test")
                .toUser(configStorage.getOpenid())
                .scene("1000")
                .contentColor("#FF0000")
                .contentValue("Send subscribe message test")
                .build();

        try {
            boolean send = this.wxService.getSubscribeMsgService().sendSubscribeMessage(message);
            Assert.assertTrue(send);
        } catch (WxErrorException e) {
            // 当用户没有授权，获取之前的授权已使用。微信会返回错误代码 {"errcode":43101,"errmsg":"user refuse to accept the msg hint: [xxxxxxxxxxx]"}
            if (e.getError().getErrorCode() != 43101) {
                throw e;
            }
        }
    }
}
