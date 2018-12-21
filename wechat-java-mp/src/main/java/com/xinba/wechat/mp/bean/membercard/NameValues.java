package com.xinba.wechat.mp.bean.membercard;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class NameValues implements Serializable{
  private static final long serialVersionUID = -8529369702944594330L;

  private String name;

  private String value;

  private String[] valueList;

}
