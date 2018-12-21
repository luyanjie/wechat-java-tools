package com.xinba.wechat.mp.util.json;

import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.mp.bean.datacube.WxDataCubeUserCumulate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Type;
import java.text.ParseException;

/**
 * @author jokin
 * @date 2018/12/18 15:55
 * */
@Slf4j
public class WxMpUserCumulateGsonAdapter implements JsonDeserializer<WxDataCubeUserCumulate> {

  private static final FastDateFormat DATE_FORMAT = FastDateFormat
    .getInstance("yyyy-MM-dd");

  @Override
  public WxDataCubeUserCumulate deserialize(JSONObject json, Type type) {
    WxDataCubeUserCumulate cumulate = new WxDataCubeUserCumulate();
    try {
      String refDate = json.getString("ref_date");
      if (refDate != null) {
        cumulate.setRefDate(DATE_FORMAT.parse(refDate));
      }
      cumulate.setCumulateUser(json.getInteger("cumulate_user"));
    } catch (ParseException e) {
      log.error("",e);
    }
    return cumulate;

  }

}
