package com.xinba.wechat.mp.util.crypto;

import com.xinba.wechat.common.util.crypto.WxCryptUtil;
import com.xinba.wechat.mp.api.WxMpConfigStorage;
import org.apache.commons.codec.binary.Base64;

/**
 * @author jokin
 * @date 2018/12/18 14:35
 */
public class WxMpCryptUtil extends WxCryptUtil {
    /**
     * 构造函数
     *
     * @param wxMpConfigStorage
     */
    public WxMpCryptUtil(WxMpConfigStorage wxMpConfigStorage) {
    /*
     * @param token          公众平台上，开发者设置的token
     * @param encodingAesKey 公众平台上，开发者设置的EncodingAESKey
     * @param appId          公众平台appid
     */
        String encodingAesKey = wxMpConfigStorage.getAesKey();
        String token = wxMpConfigStorage.getToken();
        String appId = wxMpConfigStorage.getAppId();

        this.token = token;
        this.appidOrCorpid = appId;
        this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
    }
}
