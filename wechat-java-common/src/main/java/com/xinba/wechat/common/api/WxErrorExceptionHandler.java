package com.xinba.wechat.common.api;

import com.xinba.wechat.common.error.WxErrorException;

/**
 * @author jokin
 * @date 2018/12/17 11:56
 */
public interface WxErrorExceptionHandler {
    void handle(WxErrorException e);
}
