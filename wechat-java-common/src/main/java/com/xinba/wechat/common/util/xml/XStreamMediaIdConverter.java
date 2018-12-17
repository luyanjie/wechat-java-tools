package com.xinba.wechat.common.util.xml;

/**
 * @author jokin
 * @date 2018/12/17 16:14
 */
public class XStreamMediaIdConverter extends XStreamCDataConverter {
    @Override
    public String toString(Object obj) {
        return "<MediaId>" + super.toString(obj) + "</MediaId>";
    }
}