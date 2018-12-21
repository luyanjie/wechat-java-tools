package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:26
 *
 * 会员卡激活，用户提交信息
 */
@Data
public class MemberCardActivateUserFormRequest implements Serializable {
    @JSONField(name = "card_id")
    private String cardId;

    @JSONField(name = "service_statement")
    private JSONObject serviceStatement;

    @JSONField(name = "bind_old_card")
    private JSONObject bindOldCard;

    /**
     * 必填项
     */
    @JSONField(name = "required_form")
    private MemberCardUserForm requiredForm;

    /**
     * 可选项
     */
    @JSONField(name = "optional_form")
    private MemberCardUserForm optionalForm;

    /**
     * 绑定老会员卡信息
     *
     * @param name
     * @param url
     */
    public void setBindOldCard(String name, String url) {
        if (StringUtils.isAnyEmpty(name, url)) {
            return;
        }
        if (bindOldCard == null){
            bindOldCard = new JSONObject();}
        bindOldCard.put("name", name);
        bindOldCard.put("url", url);
    }

    /**
     * 设置服务声明，用于放置商户会员卡守则
     *
     * @param name
     * @param url
     */
    public void setServiceStatement(String name, String url) {
        if (StringUtils.isAnyEmpty(name, url)) {
            return;
        }
        if (serviceStatement == null){
            serviceStatement = new JSONObject();}
        serviceStatement.put("name", name);
        serviceStatement.put("url", url);
    }
}
