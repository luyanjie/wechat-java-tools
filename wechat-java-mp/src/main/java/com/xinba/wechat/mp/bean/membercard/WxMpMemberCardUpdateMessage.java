package com.xinba.wechat.mp.bean.membercard;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 更新会员信息所需字段消息。
 *
 * 1.开发者可以同时传入add_bonus和bonus解决由于同步失败带来的幂等性问题。同时传入add_bonus和bonus时
 * add_bonus作为积分变动消息中的变量值，而bonus作为卡面上的总积分额度显示。余额变动同理。
 * 2.开发者可以传入is_notify_bonus控制特殊的积分对账变动不发送消息，余额变动同理。
 * </pre>
 *
 * @author jokin
 * @date 2018/12/18 11:55
 */
@Data
public class WxMpMemberCardUpdateMessage implements Serializable {

  private static final long serialVersionUID = -2744520491279530262L;
  /**
   * 领取会员卡用户获得的code
   */
  private String code;
  /**
   * 卡券ID,自定义code卡券必填
   */
  @JSONField(name = "card_id")
  private String cardId;
  /**
   * 支持商家激活时针对单个会员卡分配自定义的会员卡背景
   */
  @JSONField(name = "background_pic_url")
  private String backgroundPicUrl;
  /**
   * 需要设置的积分全量值，传入的数值会直接显示
   */
  private Integer bonus;
  /**
   * 本次积分变动值，传负数代表减少
   */
  @JSONField(name = "add_bonus")
  private Integer addBounus;
  /**
   * 商家自定义积分消耗记录，不超过14个汉字
   */
  @JSONField(name = "record_bonus")
  private String recordBonus;
  /**
   * 需要设置的余额全量值，传入的数值会直接显示在卡面
   */
  private Double balance;
  /**
   * 本次余额变动值，传负数代表减少
   */
  @JSONField(name = "add_balance")
  private Double addBalance;
  /**
   * 商家自定义金额消耗记录，不超过14个汉字。
   */
  @JSONField(name = "record_balance")
  private String recordBalance;

  /**
   * 创建时字段custom_field定义类型的最新数值，限制为4个汉字，12字节。
   */
  @JSONField(name = "custom_field_value1")
  private String customFieldValue1;
  @JSONField(name = "custom_field_value2")
  private String customFieldValue2;
  @JSONField(name = "custom_field_value3")
  private String customFieldValue3;

  @JSONField(name = "notify_optional")
  private NotifyOptional notifyOptional;

}
