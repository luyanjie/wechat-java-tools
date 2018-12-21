package com.xinba.wechat.mp.bean.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/12/18 10:41
 *
 * 卡券初始页面请求信息
 */
@Data
public class WxMpCardLandingPageCreateRequest implements Serializable {

    private static final long serialVersionUID = -5103440321296679901L;
    /**
     * 页面的banner图片链接，须调用，建议尺寸为640*300。
     */
    private String banner;

    /**
     * 页面的title
     */
    @JSONField(name = "page_title")
    private String title;

    @JSONField(name = "can_share")
    private boolean canShare;

    /**
     * 投放页面的场景值；
     * SCENE_NEAR_BY 附近
     * SCENE_MENU 自定义菜单
     * SCENE_QRCODE 二维码
     * SCENE_ARTICLE 公众号文章
     * SCENE_H5 h5页面
     * SCENE_IVR 自动回复
     * SCENE_CARD_CUSTOM_CELL 卡券自定义cell
     */
    private String scene;

    @JSONField(name = "card_list")
    private JSONArray cardList;

    public void addCard(String cardId, String thumbUrl) {
        if (StringUtils.isNoneBlank(cardId, thumbUrl)) {
            if (cardList == null){
                cardList = new JSONArray();}
            JSONObject cardJson = new JSONObject();
            cardJson.put("card_id", cardId);
            cardJson.put("thumb_url", thumbUrl);
            cardList.add(cardJson);
        }
    }

    public static WxMpCardLandingPageCreateRequest fromJson(String json) {
        return JSON.parseObject(json, WxMpCardLandingPageCreateRequest.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
