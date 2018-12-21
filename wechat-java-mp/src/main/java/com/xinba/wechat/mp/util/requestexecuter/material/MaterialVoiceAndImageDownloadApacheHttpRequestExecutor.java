package com.xinba.wechat.mp.util.requestexecuter.material;

import com.alibaba.fastjson.JSON;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.common.util.http.apache.InputStreamResponseHandler;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialVoiceAndImageDownloadApacheHttpRequestExecutor extends MaterialVoiceAndImageDownloadRequestExecutor<CloseableHttpClient, HttpHost> {
    public MaterialVoiceAndImageDownloadApacheHttpRequestExecutor(RequestHttp requestHttp, File tmpDirFile) {
        super(requestHttp, tmpDirFile);
    }

    @Override
    public InputStream execute(String uri, String materialId) throws WxErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpPost.setConfig(config);
        }

        Map<String, String> params = new HashMap<>();
        params.put("media_id", materialId);
        httpPost.setEntity(new StringEntity(JSON.toJSONString(params)));
        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost);
             InputStream inputStream = InputStreamResponseHandler.INSTANCE.handleResponse(response)) {
            // 下载媒体文件出错
            byte[] responseContent = IOUtils.toByteArray(inputStream);
            String responseContentString = new String(responseContent, StandardCharsets.UTF_8);
            if (responseContentString.length() < 100) {
                try {
                    WxError wxError = JSON.parseObject(responseContentString, WxError.class);
                    if (wxError.getErrorCode() != 0) {
                        throw new WxErrorException(wxError);
                    }
                } catch (Exception ex) {
                    return new ByteArrayInputStream(responseContent);
                }
            }
            return new ByteArrayInputStream(responseContent);
        } finally {
            httpPost.releaseConnection();
        }
    }
}
