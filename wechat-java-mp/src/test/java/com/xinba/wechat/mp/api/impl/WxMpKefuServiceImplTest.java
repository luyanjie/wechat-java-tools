package com.xinba.wechat.mp.api.impl;

import com.google.inject.Inject;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.api.test.TestConfigStorage;
import com.xinba.wechat.mp.bean.kefu.WxMpKefuMessage;
import com.xinba.wechat.mp.bean.kefu.request.WxMpKfAccountRequest;
import com.xinba.wechat.mp.bean.kefu.result.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.*;

import java.io.File;
import java.util.Date;


/**
 * 测试客服相关接口
 *
 * @author Binary Wang
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMpKefuServiceImplTest {

    @Inject
    protected WxMpService wxService;

    public void testSendKefuMpNewsMessage() throws WxErrorException {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConstant.KefuMsgType.MPNEWS);
        message.setToUser(configStorage.getOpenid());
        message.setMpNewsMediaId("52R6dL2FxDpM9N1rCY3sYBqHwq-L7K_lz1sPI71idMg");

        boolean result = this.wxService.getKefuService().sendKefuMessage(message);
        //assertThat(result).isTrue();
    }

    public void testSendKefuMessage() throws WxErrorException {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConstant.KefuMsgType.TEXT);
        message.setToUser(configStorage.getOpenid());
        message.setContent("欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");

        boolean result = this.wxService.getKefuService().sendKefuMessage(message);
        System.out.println(result);
    }

    public void testSendKefuMessageWithKfAccount() throws WxErrorException {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConstant.KefuMsgType.TEXT);
        message.setToUser(configStorage.getOpenid());
        message.setKfAccount(configStorage.getKfAccount());
        message.setContent("欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");

        boolean result = this.wxService.getKefuService().sendKefuMessage(message);
        // assertThat(result).isTrue();
    }

    public void testKfList() throws WxErrorException {
        WxMpKfList kfList = this.wxService.getKefuService().kfList();
        // assertThat(kfList).isNotNull();
        for (WxMpKfInfo k : kfList.getKfList()) {
            System.err.println(k);
        }
    }

    public void testKfOnlineList() throws WxErrorException {
        WxMpKfOnlineList kfOnlineList = this.wxService.getKefuService().kfOnlineList();
        //assertThat(kfOnlineList).isNotNull();
        for (WxMpKfInfo k : kfOnlineList.getKfOnlineList()) {
            System.err.println(k);
        }
    }

    @DataProvider
    public Object[][] getKfAccount() {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        return new Object[][]{{configStorage.getKfAccount()}};
    }

    @Test(dataProvider = "getKfAccount")
    public void testKfAccountAdd(String kfAccount) throws WxErrorException {
        WxMpKfAccountRequest request = WxMpKfAccountRequest.builder()
                .kfAccount(kfAccount).nickName("我晕").build();
        //assertThat(this.wxService.getKefuService().kfAccountAdd(request)).isTrue();
    }

    @Test(dependsOnMethods = {
            "testKfAccountAdd"}, dataProvider = "getKfAccount")
    public void testKfAccountUpdate(String kfAccount) throws WxErrorException {
        WxMpKfAccountRequest request = WxMpKfAccountRequest.builder()
                .kfAccount(kfAccount).nickName("我晕").build();
        //assertThat(this.wxService.getKefuService().kfAccountUpdate(request)).isTrue();
    }

    @Test(dependsOnMethods = {
            "testKfAccountAdd"}, dataProvider = "getKfAccount")
    public void testKfAccountInviteWorker(String kfAccount) throws WxErrorException {
        WxMpKfAccountRequest request = WxMpKfAccountRequest.builder()
                .kfAccount(kfAccount).inviteWx("    ").build();
        //assertThat(this.wxService.getKefuService().kfAccountInviteWorker(request)).isTrue();
    }

    @Test(dependsOnMethods = {"testKfAccountUpdate", "testKfAccountAdd"}, dataProvider = "getKfAccount")
    public void testKfAccountUploadHeadImg(String kfAccount) throws WxErrorException {
        File imgFile = new File("src\\test\\resources\\mm.jpeg");
        boolean result = this.wxService.getKefuService().kfAccountUploadHeadImg(kfAccount, imgFile);
        //assertThat(result).isTrue();
    }

    @Test(dataProvider = "getKfAccount")
    public void testKfAccountDel(String kfAccount) throws WxErrorException {
        boolean result = this.wxService.getKefuService().kfAccountDel(kfAccount);
        // assertThat(result).isTrue();
    }

    @DataProvider
    public Object[][] getKfAccountAndOpenid() {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        return new Object[][]{{configStorage.getKfAccount(), configStorage.getOpenid()}};
    }

    @Test(dataProvider = "getKfAccountAndOpenid")
    public void testKfSessionCreate(String kfAccount, String openid) throws WxErrorException {
        boolean result = this.wxService.getKefuService().kfSessionCreate(openid, kfAccount);
        //assertThat(result).isTrue();
    }

    @Test(dataProvider = "getKfAccountAndOpenid")
    public void testKfSessionClose(String kfAccount, String openid) throws WxErrorException {
        boolean result = this.wxService.getKefuService().kfSessionClose(openid, kfAccount);
        //assertThat(result).isTrue();
    }

    @Test(dataProvider = "getKfAccountAndOpenid")
    public void testKfSessionGet(@SuppressWarnings("unused") String kfAccount, String openid) throws WxErrorException {
        WxMpKfSessionGetResult result = this.wxService.getKefuService().kfSessionGet(openid);
        //assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test(dataProvider = "getKfAccount")
    public void testKfSessionList(String kfAccount) throws WxErrorException {
        WxMpKfSessionList result = this.wxService.getKefuService().kfSessionList(kfAccount);
        //assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test
    public void testKfSessionGetWaitCase() throws WxErrorException {
        WxMpKfSessionWaitCaseList result = this.wxService.getKefuService().kfSessionGetWaitCase();
        //assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test
    public void testKfMsgList() throws WxErrorException {
        Date startTime = DateUtils.addDays(new Date(), -1);
        Date endTime = DateUtils.addDays(new Date(), 0);
        WxMpKfMsgList result = this.wxService.getKefuService().kfMsgList(startTime, endTime, 1L, 50);
        //assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test
    public void testKfMsgListAll() throws WxErrorException {
        Date startTime = DateUtils.addDays(new Date(), -1);
        Date endTime = DateUtils.addDays(new Date(), 0);
        WxMpKfMsgList result = this.wxService.getKefuService().kfMsgList(startTime, endTime);
        // assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test
    public void testSendKfTypingState() throws WxErrorException {
        TestConfigStorage configStorage = (TestConfigStorage) this.wxService.getWxMpConfigStorage();
        boolean result = this.wxService.getKefuService().sendKfTypingState(configStorage.getOpenid(), "Typing");
        // assertThat(result).isTrue();
    }
}
