package com.xinba.wechat.mp.util.requestexecuter.material;


import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.mp.bean.material.WxMpMaterialNews;

public abstract class MaterialNewsInfoRequestExecutor<H, P> implements RequestExecutor<WxMpMaterialNews, String> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialNewsInfoRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<WxMpMaterialNews, String> create(RequestHttp requestHttp) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new MaterialNewsInfoApacheHttpRequestExecutor(requestHttp);
      case JODD_HTTP:
        return new MaterialNewsInfoJoddHttpRequestExecutor(requestHttp);
      case OK_HTTP:
        return new MaterialNewsInfoOkhttpRequestExecutor(requestHttp);
      default:
        //TODO 需要优化抛出异常
        return null;
    }
  }

}
