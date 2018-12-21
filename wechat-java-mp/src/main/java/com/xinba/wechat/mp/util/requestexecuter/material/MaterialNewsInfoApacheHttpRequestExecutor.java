package com.xinba.wechat.mp.util.requestexecuter.material;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.common.util.http.apache.Utf8ResponseHandler;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * httpclient 实现的素材请求执行器.
 *
 * @author ecoolper
 * @date 2017/5/5
 */
public class MaterialNewsInfoApacheHttpRequestExecutor
        extends MaterialNewsInfoRequestExecutor<CloseableHttpClient, HttpHost> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MaterialNewsInfoApacheHttpRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMpMaterialNews execute(String uri, String materialId) throws WxErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpPost.setConfig(config);
        }

        httpPost.setEntity(new StringEntity(JSON.toJSONString(ImmutableMap.of("media_id", materialId))));
        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            this.logger.debug("响应原始数据：{}", responseContent);
            WxError error = WxError.fromJson(responseContent, WxType.MP);
            if (error.getErrorCode() != 0) {
                throw new WxErrorException(error);
            } else {
                return JSON.parseObject(responseContent, WxMpMaterialNews.class);
            }
        } finally {
            httpPost.releaseConnection();
        }
    }
}
