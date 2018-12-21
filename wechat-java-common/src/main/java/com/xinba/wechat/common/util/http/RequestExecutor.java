package com.xinba.wechat.common.util.http;


import com.xinba.wechat.common.error.WxErrorException;

import java.io.IOException;

/**
 * http请求执行器
 *
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 * @author jokin
 */
public interface RequestExecutor<T, E> {

  /**
   * @param uri  uri
   * @param data 数据
   */
  T execute(String uri, E data) throws WxErrorException, IOException;
}
