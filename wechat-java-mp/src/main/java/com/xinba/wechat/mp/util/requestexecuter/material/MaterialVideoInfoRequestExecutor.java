package com.xinba.wechat.mp.util.requestexecuter.material;


import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.mp.bean.material.WxMpMaterialVideoInfoResult;

public abstract class MaterialVideoInfoRequestExecutor<H, P> implements RequestExecutor<WxMpMaterialVideoInfoResult, String> {
    protected RequestHttp<H, P> requestHttp;

    public MaterialVideoInfoRequestExecutor(RequestHttp requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<WxMpMaterialVideoInfoResult, String> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new MaterialVideoInfoApacheHttpRequestExecutor(requestHttp);
            case JODD_HTTP:
                return new MaterialVideoInfoJoddHttpRequestExecutor(requestHttp);
            case OK_HTTP:
                return new MaterialVideoInfoOkhttpRequestExecutor(requestHttp);
            default:
                return null;
        }
    }

}
