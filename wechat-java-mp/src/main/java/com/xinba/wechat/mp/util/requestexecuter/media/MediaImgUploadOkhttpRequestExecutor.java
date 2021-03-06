package com.xinba.wechat.mp.util.requestexecuter.media;

import com.xinba.wechat.common.WxType;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.common.util.http.okhttp.OkHttpProxyInfo;
import com.xinba.wechat.mp.bean.material.WxMediaImgUploadResult;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 *
 * @author ecoolper
 */
public class MediaImgUploadOkhttpRequestExecutor extends MediaImgUploadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MediaImgUploadOkhttpRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMediaImgUploadResult execute(String uri, File file) throws WxErrorException, IOException {
        logger.debug("MediaImgUploadOkhttpRequestExecutor is running");
        //得到httpClient
        OkHttpClient client = requestHttp.getRequestHttpClient();

        RequestBody body = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("media",
                        file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();

        Request request = new Request.Builder().url(uri).post(body).build();
        Response response = client.newCall(request).execute();
        String responseContent = response.body().string();
        WxError error = WxError.fromJson(responseContent, WxType.MP);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        }

        return WxMediaImgUploadResult.fromJson(responseContent);
    }
}
