package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.datacube.WxDataCubeUserSummary;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Type;
import java.text.ParseException;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
@Slf4j
public class WxMpUserSummaryGsonAdapter implements JsonDeserializer<WxDataCubeUserSummary> {

    private static final FastDateFormat DATE_FORMAT = FastDateFormat
            .getInstance("yyyy-MM-dd");

    @Override
    public WxDataCubeUserSummary deserialize(JSONObject json, Type type) {
        WxDataCubeUserSummary summary = new WxDataCubeUserSummary();

        try {
            String refDate = json.getString("ref_date");
            if (refDate != null) {
                summary.setRefDate(DATE_FORMAT.parse(refDate));
            }
            summary.setUserSource(json.getInteger("user_source"));
            summary.setNewUser(json.getInteger("new_user"));
            summary.setCancelUser(json.getInteger("cancel_user"));
        } catch (ParseException e) {
            log.error("", e);
        }
        return summary;
    }

}
