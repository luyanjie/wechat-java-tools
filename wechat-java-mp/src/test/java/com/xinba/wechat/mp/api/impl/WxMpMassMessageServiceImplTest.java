package com.xinba.wechat.mp.api.impl;

import com.google.inject.Inject;
import com.xinba.wechat.common.api.WxConstant;
import com.xinba.wechat.common.bean.result.WxMediaUploadResult;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.api.test.ApiTestModule;
import com.xinba.wechat.mp.api.test.TestConfigStorage;
import com.xinba.wechat.mp.api.test.TestConstants;
import com.xinba.wechat.mp.bean.WxMpMassNews;
import com.xinba.wechat.mp.bean.WxMpMassOpenIdsMessage;
import com.xinba.wechat.mp.bean.WxMpMassTagMessage;
import com.xinba.wechat.mp.bean.WxMpMassVideo;
import com.xinba.wechat.mp.bean.result.WxMpMassSendResult;
import com.xinba.wechat.mp.bean.result.WxMpMassUploadResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

/**
 * 测试群发消息
 *
 * @author chanjarster
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMpMassMessageServiceImplTest {
    @Inject
    protected WxMpService wxService;

    @Test
    public void testTextMassOpenIdsMessageSend() throws WxErrorException {
        // 发送群发消息
        TestConfigStorage configProvider = (TestConfigStorage) this.wxService
                .getWxMpConfigStorage();
        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(WxConstant.MassMsgType.TEXT);
        massMessage.setContent("测试群发消息\n欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");
        massMessage.getToUsers().add(configProvider.getOpenid());

        WxMpMassSendResult massResult = this.wxService.getMassMessageService()
                .massOpenIdsMessageSend(massMessage);
        assertNotNull(massResult);
        assertNotNull(massResult.getMsgId());
    }

    @Test(dataProvider = "massMessages")
    public void testMediaMassOpenIdsMessageSend(String massMsgType, String mediaId) throws WxErrorException {
        // 发送群发消息
        TestConfigStorage configProvider = (TestConfigStorage) this.wxService
                .getWxMpConfigStorage();
        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(massMsgType);
        massMessage.setMediaId(mediaId);
        massMessage.getToUsers().add(configProvider.getOpenid());

        WxMpMassSendResult massResult = this.wxService.getMassMessageService()
                .massOpenIdsMessageSend(massMessage);
        assertNotNull(massResult);
        assertNotNull(massResult.getMsgId());
    }

    @Test
    public void testTextMassGroupMessageSend() throws WxErrorException {
        WxMpMassTagMessage massMessage = new WxMpMassTagMessage();
        massMessage.setMsgType(WxConstant.MassMsgType.TEXT);
        massMessage.setContent("测试群发消息\n欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");
        massMessage
                .setTagId(this.wxService.getUserTagService().tagGet().get(0).getId());

        WxMpMassSendResult massResult = this.wxService.getMassMessageService()
                .massGroupMessageSend(massMessage);
        assertNotNull(massResult);
        assertNotNull(massResult.getMsgId());
    }

    @Test(dataProvider = "massMessages")
    public void testMediaMassGroupMessageSend(String massMsgType, String mediaId)
            throws WxErrorException {
        WxMpMassTagMessage massMessage = new WxMpMassTagMessage();
        massMessage.setMsgType(massMsgType);
        massMessage.setMediaId(mediaId);
        massMessage.setTagId(this.wxService.getUserTagService().tagGet().get(0).getId());

        WxMpMassSendResult massResult = this.wxService.getMassMessageService()
                .massGroupMessageSend(massMessage);
        assertNotNull(massResult);
        assertNotNull(massResult.getMsgId());
    }

    @DataProvider
    public Object[][] massMessages() throws WxErrorException, IOException {
        Object[][] messages = new Object[4][];

    /*
     * 视频素材
     */
        try (InputStream inputStream = ClassLoader
                .getSystemResourceAsStream("mm.mp4")) {
            // 上传视频到媒体库
            WxMediaUploadResult uploadMediaRes = this.wxService.getMaterialService()
                    .mediaUpload(WxConstant.MediaFileType.VIDEO, TestConstants.FILE_MP4, inputStream);
            assertNotNull(uploadMediaRes);
            assertNotNull(uploadMediaRes.getMediaId());

            // 把视频变成可被群发的媒体
            WxMpMassVideo video = new WxMpMassVideo();
            video.setTitle("测试标题");
            video.setDescription("测试描述");
            video.setMediaId(uploadMediaRes.getMediaId());
            WxMpMassUploadResult uploadResult = this.wxService.getMassMessageService().massVideoUpload(video);
            assertNotNull(uploadResult);
            assertNotNull(uploadResult.getMediaId());
            messages[0] = new Object[]{WxConstant.MassMsgType.MPVIDEO, uploadResult.getMediaId()};
        }

    /*
     * 图片素材
     */
        try (InputStream inputStream = ClassLoader
                .getSystemResourceAsStream("mm.jpeg")) {
            WxMediaUploadResult uploadMediaRes = this.wxService.getMaterialService()
                    .mediaUpload(WxConstant.MediaFileType.IMAGE, TestConstants.FILE_JPG, inputStream);
            assertNotNull(uploadMediaRes);
            assertNotNull(uploadMediaRes.getMediaId());
            messages[1] = new Object[]{WxConstant.MassMsgType.IMAGE, uploadMediaRes.getMediaId()};
        }

    /*
     * 语音素材
     */
        try (InputStream inputStream = ClassLoader
                .getSystemResourceAsStream("mm.mp3")) {
            WxMediaUploadResult uploadMediaRes = this.wxService.getMaterialService()
                    .mediaUpload(WxConstant.MediaFileType.VOICE, TestConstants.FILE_MP3, inputStream);
            assertNotNull(uploadMediaRes);
            assertNotNull(uploadMediaRes.getMediaId());
            messages[2] = new Object[]{WxConstant.MassMsgType.VOICE, uploadMediaRes.getMediaId()};
        }

    /*
     * 图文素材
     */
        try (InputStream inputStream = ClassLoader
                .getSystemResourceAsStream("mm.jpeg")) {
            // 上传照片到媒体库
            WxMediaUploadResult uploadMediaRes = this.wxService.getMaterialService()
                    .mediaUpload(WxConstant.MediaFileType.IMAGE, TestConstants.FILE_JPG, inputStream);
            assertNotNull(uploadMediaRes);
            assertNotNull(uploadMediaRes.getMediaId());

            // 上传图文消息
            WxMpMassNews news = new WxMpMassNews();
            WxMpMassNews.WxMpMassNewsArticle article1 = new WxMpMassNews.WxMpMassNewsArticle();
            article1.setTitle("标题1");
            article1.setContent("内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1");
            article1.setThumbMediaId(uploadMediaRes.getMediaId());
            news.addArticle(article1);

            WxMpMassNews.WxMpMassNewsArticle article2 = new WxMpMassNews.WxMpMassNewsArticle();
            article2.setTitle("标题2");
            article2.setContent("内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2");
            article2.setThumbMediaId(uploadMediaRes.getMediaId());
            article2.setShowCoverPic(true);
            article2.setAuthor("作者2");
            article2.setContentSourceUrl("www.baidu.com");
            article2.setDigest("摘要2");
            news.addArticle(article2);

            WxMpMassUploadResult massUploadResult = this.wxService.getMassMessageService()
                    .massNewsUpload(news);
            assertNotNull(massUploadResult);
            assertNotNull(uploadMediaRes.getMediaId());
            messages[3] = new Object[]{WxConstant.MassMsgType.MPNEWS, massUploadResult.getMediaId()};
        }

        return messages;
    }

    @Test
    public void testMassDelete() throws Exception {
        this.wxService.getMassMessageService().delete(1L, 2);
    }

}
