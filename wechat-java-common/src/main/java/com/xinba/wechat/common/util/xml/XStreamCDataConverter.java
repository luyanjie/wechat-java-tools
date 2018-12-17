package com.xinba.wechat.common.util.xml;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * @author jokin
 * @date 2018/12/17 16:14
 */
public class XStreamCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }

}
