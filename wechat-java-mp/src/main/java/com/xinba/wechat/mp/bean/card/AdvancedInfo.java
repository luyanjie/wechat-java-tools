package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.mp.bean.card.enums.BusinessServiceType;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 10:03
 *
 * 微信会员卡高级字段信息
 */
@Data
public class AdvancedInfo {

    /**
     * 使用门槛（条件）,若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
     */
    @JSONField(name = "use_condition")
    private UseCondition useCondition;

    /**
     * 封面摘要
     */
    @JSONField(name = "abstract")
    private Abstract abstractInfo;

    /**
     * 图文列表,显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
     */
    @JSONField(name = "text_image_list")
    private List<TextImageList> textImageList;

    /**
     * 商家服务类型,数组类型:BIZ_SERVICE_DELIVER 外卖服务； BIZ_SERVICE_FREE_PARK 停车位； BIZ_SERVICE_WITH_PET 可带宠物； BIZ_SERVICE_FREE_WIFI 免费wifi， 可多选
     */
    @JSONField(name = "business_service")
    private List<String> businessServiceList;

    /**
     * 使用时段限制
     */
    @JSONField(name ="time_limit")
    private TimeLimit timeLimit;

    /**
     * 是否可以分享朋友
     */
    @JSONField(name = "share_friends")
    private Boolean shareFriends;

    public void addBusinessService(BusinessServiceType businessServiceType) {
        if (businessServiceType != null) {
            if (businessServiceList == null)
                businessServiceList = new ArrayList<String>();
            businessServiceList.add(businessServiceType.name());
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
