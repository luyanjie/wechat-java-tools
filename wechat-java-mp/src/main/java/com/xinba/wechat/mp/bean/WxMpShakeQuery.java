package com.xinba.wechat.mp.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/17 18:26
 *
 * 查询票据
 */
@Data
public class WxMpShakeQuery implements Serializable {
    private static final long serialVersionUID = 1963276195699741675L;

    private String ticket;

    private int needPoi;

    public String toJson(){
        return JSON.toJSONString(this);
    }
}
