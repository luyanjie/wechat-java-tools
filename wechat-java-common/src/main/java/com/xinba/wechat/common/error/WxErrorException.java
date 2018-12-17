package com.xinba.wechat.common.error;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 11:56
 */
public class WxErrorException extends Exception implements Serializable {

    private static final long serialVersionUID = -2520294209055424288L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }
}
