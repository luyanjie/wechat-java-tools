package com.xinba.wechat.api;

import com.xinba.wechat.error.WxErrorException;

/**
 * @author jokin
 * @date 2018/12/17 11:56
 */
public interface WxErrorExceptionHandler {
    void handle(WxErrorException e);
}
