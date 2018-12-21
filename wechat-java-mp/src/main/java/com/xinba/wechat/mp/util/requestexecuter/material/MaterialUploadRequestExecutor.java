package com.xinba.wechat.mp.util.requestexecuter.material;

import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.common.util.http.RequestHttp;
import com.xinba.wechat.mp.bean.material.WxMpMaterial;
import com.xinba.wechat.mp.bean.material.WxMpMaterialUploadResult;

/**
 * @author codepiano
 */
public abstract class MaterialUploadRequestExecutor<H, P> implements RequestExecutor<WxMpMaterialUploadResult, WxMpMaterial> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialUploadRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<WxMpMaterialUploadResult, WxMpMaterial> create(RequestHttp requestHttp) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new MaterialUploadApacheHttpRequestExecutor(requestHttp);
      case JODD_HTTP:
        return new MaterialUploadJoddHttpRequestExecutor(requestHttp);
      case OK_HTTP:
        return new MaterialUploadOkhttpRequestExecutor(requestHttp);
      default:
        return null;
    }
  }

}
