package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.template.WxMpTemplateIndustry;

import java.lang.reflect.Type;

/**
 * @author jokin
 * @date 2018/12/18 16:33
 */
public class WxMpIndustryJsonAdapter
        implements JsonSerializer<WxMpTemplateIndustry>, JsonDeserializer<WxMpTemplateIndustry>{

    private static WxMpTemplateIndustry.Industry convertFromJson(JSONObject json) {
        WxMpTemplateIndustry.Industry industry = new WxMpTemplateIndustry.Industry();
        industry.setFirstClass(json.getString("first_class"));
        industry.setSecondClass(json.getString( "second_class"));
        return industry;
    }

    @Override
    public JSONObject serialize(WxMpTemplateIndustry wxMpIndustry, Type var2) {
        JSONObject json = new JSONObject();
        json.put("industry_id1", wxMpIndustry.getPrimaryIndustry().getId());
        json.put("industry_id2", wxMpIndustry.getSecondIndustry().getId());
        return json;
    }

    @Override
    public WxMpTemplateIndustry deserialize(JSONObject json, Type type) {
        WxMpTemplateIndustry wxMpIndustry = new WxMpTemplateIndustry();
        JSONObject primaryIndustry = json
                .getJSONObject("primary_industry");
        wxMpIndustry.setPrimaryIndustry(convertFromJson(primaryIndustry));
        JSONObject secondaryIndustry = json
                .getJSONObject("secondary_industry");
        wxMpIndustry.setSecondIndustry(convertFromJson(secondaryIndustry));
        return wxMpIndustry;
    }


}
