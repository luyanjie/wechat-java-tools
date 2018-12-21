package com.xinba.wechat.mp.util.requestexecuter.qrcode;

import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.mp.bean.result.WxMpQrCodeTicket;

import java.io.File;

/**
 * 获得QrCode图片 请求执行器
 *
 * @author chanjarster
 */
public abstract class QrCodeRequestExecutor<H, P> implements RequestExecutor<File, WxMpQrCodeTicket> {
    protected RequestHttp<H, P> requestHttp;

    public QrCodeRequestExecutor(RequestHttp requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<File, WxMpQrCodeTicket> create(RequestHttp requestHttp) throws WxErrorException {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new QrCodeApacheHttpRequestExecutor(requestHttp);
            case JODD_HTTP:
                return new QrCodeJoddHttpRequestExecutor(requestHttp);
            case OK_HTTP:
                return new QrCodeOkhttpRequestExecutor(requestHttp);
            default:
                throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("不支持的http框架").build());
        }
    }

}
