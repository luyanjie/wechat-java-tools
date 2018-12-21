package com.xinba.wechat.mp.util.requestexecuter.material;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;
import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.util.StringPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialNewsInfoJoddHttpRequestExecutor extends MaterialNewsInfoRequestExecutor<HttpConnectionProvider, ProxyInfo> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MaterialNewsInfoJoddHttpRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMpMaterialNews execute(String uri, String materialId) throws WxErrorException, IOException {
        if (requestHttp.getRequestHttpProxy() != null) {
            requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
        }

        HttpRequest request = HttpRequest.post(uri)
                .withConnectionProvider(requestHttp.getRequestHttpClient())
                .body(JSON.toJSONString(ImmutableMap.of("media_id", materialId)));
        HttpResponse response = request.send();
        response.charset(StringPool.UTF_8);

        String responseContent = response.bodyText();
        this.logger.debug("响应原始数据：{}", responseContent);
        WxError error = WxError.fromJson(responseContent, WxType.MP);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        } else {
            return JSON.parseObject(responseContent, WxMpMaterialNews.class);
        }
    }
}
