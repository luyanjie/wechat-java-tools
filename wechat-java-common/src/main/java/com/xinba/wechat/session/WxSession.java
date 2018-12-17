package com.xinba.wechat.session;

import java.util.Enumeration;

/**
 * @author jokin
 * @date 2018/12/17 15:25
 */
public interface WxSession {
    Object getAttribute(String name);

    Enumeration<String> getAttributeNames();

    void setAttribute(String name, Object value);

    void removeAttribute(String name);

    void invalidate();
}
