package com.xinba.wechat.mp.util.requestexecuter.material;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.common.util.http.okhttp.OkHttpProxyInfo;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialNewsInfoOkhttpRequestExecutor extends MaterialNewsInfoRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MaterialNewsInfoOkhttpRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMpMaterialNews execute(String uri, String materialId) throws WxErrorException, IOException {

        //得到httpClient
        OkHttpClient client = requestHttp.getRequestHttpClient();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                JSON.toJSONString(ImmutableMap.of("media_id", materialId)));
        Request request = new Request.Builder().url(uri).post(requestBody).build();

        Response response = client.newCall(request).execute();
        String responseContent = response.body().string();
        this.logger.debug("响应原始数据：{}", responseContent);

        WxError error = WxError.fromJson(responseContent, WxType.MP);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        } else {
            return JSON.parseObject(responseContent, WxMpMaterialNews.class);
        }
    }
}
