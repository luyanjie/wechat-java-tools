package com.xinba.wechat.mp.bean.card.enums;

import lombok.Getter;

/**
 * @author jokin
 * @date 2018/12/18 10:06
 *
 * 商户提供服务类型
 */
@Getter
public enum  BusinessServiceType {
    /**
     * 外卖服务
     * */
    BIZ_SERVICE_DELIVER("外卖服务"),
    /**
     * 停车位
     * */
    BIZ_SERVICE_FREE_PARK("停车位"),
    /**
     * 可带宠物
     * */
    BIZ_SERVICE_WITH_PET("可带宠物"),
    /**
     * 免费上网
     * */
    BIZ_SERVICE_FREE_WIFI("免费上网");

    private String description;

    BusinessServiceType(String description) {
        this.description = description;
    }

}
