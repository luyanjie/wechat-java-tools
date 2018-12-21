package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:20
 *
 * 会员卡
 * */
@Data
public final class MemberCard implements Serializable {

  private static final long serialVersionUID = 7953163689611827103L;
  /**
   * 会员卡背景图
   */
  @JSONField(name = "background_pic_url")
  private String backgroundPicUrl;

  /**
   * 基本信息
   */
  @JSONField(name = "base_info")
  private BaseInfo baseInfo;

  /**
   * 特权说明
   */
  @JSONField(name = "prerogative")
  private String prerogative;

  /**
   * 自动激活
   */
  @JSONField(name = "auto_activate")
  private boolean autoActivate;

  /**
   * 是否一键开卡
   */
  @JSONField(name = "wx_activate")
  private boolean wxActivate;

  /**
   * 显示积分
   */
  @JSONField(name = "supply_bonus")
  private boolean supplyBonus;

  /**
   * 查看积分外链,设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
   */
  @JSONField(name = "bonus_url")
  private String bonusUrl;

  /**
   * 支持储值
   */
  @JSONField(name = "supply_balance")
  private boolean supplyBalance;

  /**
   * 余额外链,仅适用于余额无法通过激活接口同步的情况下使用该字段。
   */
  @JSONField(name = "balance_url")
  private String balanceUrl;

  /**
   * 自定义会员类目1,会员卡激活后显示
   */
  @JSONField(name = "custom_field1")
  private CustomField customField1;

  /**
   * 自定义会员类目2
   */
  @JSONField(name = "custom_field2")
  private CustomField customField2;

  /**
   * 自定义会员类目3
   */
  @JSONField(name = "custom_field3")
  private CustomField customField3;

  /**
   * 积分清零规则
   */
  @JSONField(name = "bonus_cleared")
  private String bonusCleared;

  /**
   * 积分规则
   */
  @JSONField(name = "bonus_rules")
  private String bonusRules;

  /**
   * 储值规则
   */
  @JSONField(name = "balance_rules")
  private String balanceRules;

  /**
   * 激活会员卡的url
   */
  @JSONField(name = "activate_url")
  private String activateUrl;

  /**
   * 激活会原卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
   */
  @JSONField(name = "activate_app_brand_user_name")
  private String activateAppBrandUserName;

  /**
   * 激活会原卡url对应的小程序path
   */
  @JSONField(name = "activate_app_brand_pass")
  private String activateAppBrandPass;

  /**
   * 自定义会员信息类目，会员卡激活后显示。
   */
  @JSONField(name = "custom_cell1")
  private CustomCell1 customCell1;

  /**
   * 积分规则,JSON结构积分规则 。
   */
  @JSONField(name = "bonus_rule")
  private BonusRule bonusRule;

  /**
   * 折扣,该会员卡享受的折扣优惠,填10就是九折。
   */
  private Integer discount;

  /**
   * 创建优惠券特有的高级字段
   */
  @JSONField(name = "advanced_info")
  private AdvancedInfo advancedInfo;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static MemberCard fromJson(String json) {
    return JSON.parseObject(json, MemberCard.class);
  }
}
