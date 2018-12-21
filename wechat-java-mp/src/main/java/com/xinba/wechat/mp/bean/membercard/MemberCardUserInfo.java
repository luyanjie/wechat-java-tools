package com.xinba.wechat.mp.bean.membercard;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class MemberCardUserInfo implements Serializable {
  private static final long serialVersionUID = -4259196162619282129L;

  private NameValues[] commonFieldList;

  private NameValues[] customFieldList;

}
