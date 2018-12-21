package com.xinba.wechat.mp.util.requestexecuter.material;


import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.common.util.http.RequestHttp;

public abstract class MaterialDeleteRequestExecutor<H, P> implements RequestExecutor<Boolean, String> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialDeleteRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<Boolean, String> create(RequestHttp requestHttp) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new MaterialDeleteApacheHttpRequestExecutor(requestHttp);
      case JODD_HTTP:
        return new MaterialDeleteJoddHttpRequestExecutor(requestHttp);
      case OK_HTTP:
        return new MaterialDeleteOkhttpRequestExecutor(requestHttp);
      default:
        return null;
    }
  }

}
