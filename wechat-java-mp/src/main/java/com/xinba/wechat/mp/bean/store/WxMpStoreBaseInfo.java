package com.xinba.wechat.mp.bean.store;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.xinba.wechat.common.annotation.Required;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 门店基础信息
 *
 * @author jokin
 * @date 2018-12-18
 */
@Data
@Builder
public class WxMpStoreBaseInfo implements Serializable {

    private static final long serialVersionUID = -9009463643551512203L;
    /**
     * sid
     * 商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
     */
    @JSONField(name = "sid")
    private String sid;
    /**
     * business_name
     * 门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、地址、分店名等信息，错误示例：北京国美）
     * 不能为空，15个汉字或30个英文字符内
     */
    @Required
    @JSONField(name = "business_name")
    private String businessName;
    /**
     * branch_name
     * 分店名称（不应包含地区信息，不应与门店名有重复，错误示例：北京王府井店）
     * 10个字以内
     */
    @Required
    @JSONField(name = "branch_name")
    private String branchName;
    /**
     * province
     * 门店所在的省份（直辖市填城市名,如：北京市）
     * 10个字以内
     */
    @Required
    @JSONField(name = "province")
    private String province;
    /**
     * city
     * 门店所在的城市
     * 10个字以内
     */
    @Required
    @JSONField(name = "city")
    private String city;
    /**
     * district
     * 门店所在地区
     * 10个字以内
     */
    @Required
    @JSONField(name = "district")
    private String district;
    /**
     * address
     * 门店所在的详细街道地址（不要填写省市信息）
     * （东莞等没有“区”行政区划的城市，该字段可不必填写。其余城市必填。）
     */
    @Required
    @JSONField(name = "address")
    private String address;
    /**
     * telephone
     * 门店的电话（纯数字，区号、分机号均由“-”隔开）
     */
    @Required
    @JSONField(name = "telephone")
    private String telephone;
    /**
     * categories
     * 门店的类型（不同级分类用“,”隔开，如：美食，川菜，火锅。详细分类参见附件：微信门店类目表）
     */
    @Required
    @JSONField(name = "categories")
    private String[] categories;
    /**
     * offsetType
     * 坐标类型，1 为火星坐标（目前只能选1）
     */
    @Required
    @JSONField(name = "offset_type")
    @Builder.Default
    private final Integer offsetType = 1;
    /**
     * longitude
     * 门店所在地理位置的经度
     */
    @Required
    @JSONField(name = "longitude")
    private BigDecimal longitude;
    /**
     * latitude
     * 门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）
     */
    @Required
    @JSONField(name = "latitude")
    private BigDecimal latitude;
    /**
     * photo_list
     * 图片列表，url 形式，可以有多张图片，尺寸为 640*340px。必须为上一接口生成的url。
     * 图片内容不允许与门店不相关，不允许为二维码、员工合照（或模特肖像）、营业执照、无门店正门的街景、地图截图、公交地铁站牌、菜单截图等
     */
    @JSONField(name = "photo_list")
    private List<WxMpStorePhoto> photos;
    /**
     * recommend
     * 推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容
     * 200字以内
     */
    @JSONField(name = "recommend")
    private String recommend;
    /**
     * special
     * 特色服务，如免费wifi，免费停车，送货上门等商户能提供的特色功能或服务
     */
    @JSONField(name = "special")
    private String special;
    /**
     * introduction
     * 商户简介，主要介绍商户信息等
     * 300字以内
     */
    @JSONField(name = "introduction")
    private String introduction;
    /**
     * open_time
     * 营业时间，24 小时制表示，用“-”连接，如  8:00-20:00
     */
    @JSONField(name = "open_time")
    private String openTime;
    /**
     * avg_price
     * 人均价格，大于0 的整数
     */
    @JSONField(name = "avg_price")
    private Integer avgPrice;
    /**
     * 门店是否可用状态。1 表示系统错误、2 表示审核中、3 审核通过、4 审核驳回。当该字段为1、2、4 状态时，poi_id 为空
     */
    @JSONField(name = "available_state")
    private Integer availableState;
    /**
     * 扩展字段是否正在更新中。1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
     */
    @JSONField(name = "update_status")
    private Integer updateStatus;
    /**
     * 门店poi id
     */
    @JSONField(name = "poi_id")
    private String poiId;

    public static WxMpStoreBaseInfo fromJson(String json) {
        return JSON.parseObject(json, WxMpStoreBaseInfo.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("base_info", this);
        JSONObject business = new JSONObject();
        business.put("business", jsonObject);
        return business.toString();
    }

    @Data
    public static class WxMpStorePhoto implements Serializable {
        private static final long serialVersionUID = -2942447907614186861L;
        /**
         * 照片url
         */
        @JSONField(name = "photo_url")
        private String photoUrl;
    }
}
