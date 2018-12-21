package com.xinba.wechat.mp.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinba.wechat.common.bean.WxCardApiSignature;
import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.RandomUtils;
import com.xinba.wechat.common.util.crypto.SHA1;
import com.xinba.wechat.common.util.http.SimpleGetRequestExecutor;
import com.xinba.wechat.mp.api.WxMpCardService;
import com.xinba.wechat.mp.api.WxMpService;
import com.xinba.wechat.mp.bean.card.WxMpCardLandingPageCreateRequest;
import com.xinba.wechat.mp.bean.card.WxMpCardLandingPageCreateResult;
import com.xinba.wechat.mp.bean.card.WxMpCardQrcodeCreateResult;
import com.xinba.wechat.mp.bean.result.WxMpCardResult;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

/**
 * Created by Binary Wang on 2016/7/27.
 */
public class WxMpCardServiceImpl implements WxMpCardService {

    private final Logger log = LoggerFactory.getLogger(WxMpCardServiceImpl.class);

    private WxMpService wxMpService;


    public WxMpCardServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpService getWxMpService() {
        return this.wxMpService;
    }

    /**
     * 获得卡券api_ticket，不强制刷新卡券api_ticket
     *
     * @return 卡券api_ticket
     * @see #getCardApiTicket(boolean)
     */
    @Override
    public String getCardApiTicket() throws WxErrorException {
        return getCardApiTicket(false);
    }

    /**
     * <pre>
     * 获得卡券api_ticket
     * 获得时会检查卡券apiToken是否过期，如果过期了，那么就刷新一下，否则就什么都不干
     *
     * 详情请见：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E9.99.84.E5.BD
     * .954-.E5.8D.A1.E5.88.B8.E6.89.A9.E5.B1.95.E5.AD.97.E6.AE.B5.E5.8F.8A.E7.AD.BE.E5.90.8D.E7.94
     * .9F.E6.88.90.E7.AE.97.E6.B3.95
     * </pre>
     *
     * @param forceRefresh 强制刷新
     * @return 卡券api_ticket
     */
    @Override
    public String getCardApiTicket(boolean forceRefresh) throws WxErrorException {
        Lock lock = getWxMpService().getWxMpConfigStorage().getCardApiTicketLock();
        try {
            lock.lock();

            if (forceRefresh) {
                this.getWxMpService().getWxMpConfigStorage().expireCardApiTicket();
            }

            if (this.getWxMpService().getWxMpConfigStorage().isCardApiTicketExpired()) {
                String responseContent = this.wxMpService.execute(SimpleGetRequestExecutor.create(this.getWxMpService().getRequestHttp()), CARD_GET_TICKET, null);
                JSONObject tmpJsonElement = JSON.parseObject(responseContent);
                String cardApiTicket = tmpJsonElement.getString("ticket");
                int expiresInSeconds = tmpJsonElement.getIntValue("expires_in");
                this.getWxMpService().getWxMpConfigStorage().updateCardApiTicket(cardApiTicket, expiresInSeconds);
            }
        } finally {
            lock.unlock();
        }
        return this.getWxMpService().getWxMpConfigStorage().getCardApiTicket();
    }

    /**
     * <pre>
     * 创建调用卡券api时所需要的签名
     *
     * 详情请见：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E9.99.84.E5.BD
     * .954-.E5.8D.A1.E5.88.B8.E6.89.A9.E5.B1.95.E5.AD.97.E6.AE.B5.E5.8F.8A.E7.AD.BE.E5.90.8D.E7.94
     * .9F.E6.88.90.E7.AE.97.E6.B3.95
     * </pre>
     *
     * @param optionalSignParam 参与签名的参数数组。
     *                          可以为下列字段：app_id, card_id, card_type, code, openid, location_id
     *                          </br>注意：当做wx.chooseCard调用时，必须传入app_id参与签名，否则会造成签名失败导致拉取卡券列表为空
     * @return 卡券Api签名对象
     */
    @Override
    public WxCardApiSignature createCardApiSignature(String... optionalSignParam) throws
            WxErrorException {
        long timestamp = System.currentTimeMillis() / 1000;
        String nonceStr = RandomUtils.getRandomStr();
        String cardApiTicket = getCardApiTicket(false);

        String[] signParam = Arrays.copyOf(optionalSignParam, optionalSignParam.length + 3);
        signParam[optionalSignParam.length] = String.valueOf(timestamp);
        signParam[optionalSignParam.length + 1] = nonceStr;
        signParam[optionalSignParam.length + 2] = cardApiTicket;
        String signature = SHA1.gen(signParam);
        WxCardApiSignature cardApiSignature = new WxCardApiSignature();
        cardApiSignature.setTimestamp(timestamp);
        cardApiSignature.setNonceStr(nonceStr);
        cardApiSignature.setSignature(signature);
        return cardApiSignature;
    }

    /**
     * 卡券Code解码
     *
     * @param encryptCode 加密Code，通过JSSDK的chooseCard接口获得
     * @return 解密后的Code
     */
    @Override
    public String decryptCardCode(String encryptCode) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("encrypt_code", encryptCode);
        String responseContent = this.wxMpService.post(CARD_CODE_DECRYPT, param.toString());
        JSONObject tmpJsonElement = JSON.parseObject(responseContent);
        return tmpJsonElement.getString("code");
    }

    /**
     * 卡券Code查询
     *
     * @param cardId       卡券ID代表一类卡券
     * @param code         单张卡券的唯一标准
     * @param checkConsume 是否校验code核销状态，填入true和false时的code异常状态返回数据不同
     * @return WxMpCardResult对象
     */
    @Override
    public WxMpCardResult queryCardCode(String cardId, String code, boolean checkConsume) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("card_id", cardId);
        param.put("code", code);
        param.put("check_consume", checkConsume);
        String responseContent = this.wxMpService.post(CARD_CODE_GET, param.toString());
        return JSON.parseObject(responseContent, WxMpCardResult.class);
    }

    /**
     * 卡券Code核销。核销失败会抛出异常
     *
     * @param code 单张卡券的唯一标准
     * @return 调用返回的JSON字符串。
     * <br>可用 com.google.gson.JsonParser#parse 等方法直接取JSON串中的errcode等信息。
     */
    @Override
    public String consumeCardCode(String code) throws WxErrorException {
        return consumeCardCode(code, null);
    }

    /**
     * 卡券Code核销。核销失败会抛出异常
     *
     * @param code   单张卡券的唯一标准
     * @param cardId 当自定义Code卡券时需要传入card_id
     * @return 调用返回的JSON字符串。
     * <br>可用 com.google.gson.JsonParser#parse 等方法直接取JSON串中的errcode等信息。
     */
    @Override
    public String consumeCardCode(String code, String cardId) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("code", code);

        if (cardId != null && !"".equals(cardId)) {
            param.put("card_id", cardId);
        }

        return this.wxMpService.post(CARD_CODE_CONSUME, param.toString());
    }

    /**
     * 卡券Mark接口。
     * 开发者在帮助消费者核销卡券之前，必须帮助先将此code（卡券串码）与一个openid绑定（即mark住），
     * 才能进一步调用核销接口，否则报错。
     *
     * @param code   卡券的code码
     * @param cardId 卡券的ID
     * @param openId 用券用户的openid
     * @param isMark 是否要mark（占用）这个code，填写true或者false，表示占用或解除占用
     */
    @Override
    public void markCardCode(String code, String cardId, String openId, boolean isMark) throws
            WxErrorException {
        JSONObject param = new JSONObject();
        param.put("code", code);
        param.put("card_id", cardId);
        param.put("openid", openId);
        param.put("is_mark", isMark);
        String responseContent = this.getWxMpService().post(CARD_CODE_MARK, param.toString());
        WxMpCardResult cardResult = JSON.parseObject(responseContent, WxMpCardResult.class);
        if (!"0".equals(cardResult.getErrorCode())) {
            this.log.warn("朋友的券mark失败：{}", cardResult.getErrorMsg());
        }
    }

    @Override
    public String getCardDetail(String cardId) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("card_id", cardId);
        String responseContent = this.wxMpService.post(CARD_GET, param.toString());

        // 判断返回值
        JSONObject json = JSON.parseObject(responseContent);
        String errcode = json.getString("errcode");
        if (!"0".equals(errcode)) {
            String errmsg = json.getString("errmsg");
            throw new WxErrorException(WxError.builder()
                    .errorCode(Integer.valueOf(errcode)).errorMsg(errmsg)
                    .build());
        }

        return responseContent;
    }

    /**
     * 添加测试白名单
     *
     * @param openid 用户的openid
     * @return
     */
    @Override
    public String addTestWhiteList(String openid) throws WxErrorException {
        JSONArray array = new JSONArray();
        array.add(openid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openid", array);
        String respone = this.wxMpService.post(CARD_TEST_WHITELIST, JSON.toJSONString(jsonObject));
        return respone;
    }

    /**
     * 创建卡券二维码
     *
     * @param cardId
     * @param outerStr
     * @return
     */
    @Override
    public WxMpCardQrcodeCreateResult createQrcodeCard(String cardId, String outerStr) throws WxErrorException {
        return createQrcodeCard(cardId, outerStr, 0);
    }

    /**
     * 创建卡券二维码
     *
     * @param cardId    卡券编号
     * @param outerStr  二维码标识
     * @param expiresIn 失效时间，单位秒，不填默认365天
     * @return
     * @throws WxErrorException
     */
    @Override
    public WxMpCardQrcodeCreateResult createQrcodeCard(String cardId, String outerStr, int expiresIn) throws WxErrorException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action_name", "QR_CARD");
        if (expiresIn > 0) {
            jsonObject.put("expire_seconds", expiresIn);
        }
        JSONObject actionInfoJson = new JSONObject();
        JSONObject cardJson = new JSONObject();
        cardJson.put("card_id", cardId);
        cardJson.put("outer_str", outerStr);
        actionInfoJson.put("card", cardJson);
        jsonObject.put("action_info", actionInfoJson);
        String response = this.wxMpService.post(CARD_QRCODE_CREAET, JSON.toJSONString(jsonObject));
        return WxMpCardQrcodeCreateResult.fromJson(response);
    }

    /**
     * 创建卡券货架接口
     *
     * @param request
     * @return
     * @throws WxErrorException
     */
    @Override
    public WxMpCardLandingPageCreateResult createLandingPage(WxMpCardLandingPageCreateRequest request) throws WxErrorException {
        String response = this.wxMpService.post(CARD_LANDING_PAGE_CREAET, JSON.toJSONString(request));
        return WxMpCardLandingPageCreateResult.fromJson(response);
    }

    /**
     * 将用户的卡券设置为失效状态
     * 详见:https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1451025272&anchor=9
     *
     * @param cardId 卡券编号
     * @param code   用户会员卡号
     * @param reason 设置为失效的原因
     * @return
     * @throws WxErrorException
     */
    @Override
    public String unavailableCardCode(String cardId, String code, String reason) throws WxErrorException {
        if (StringUtils.isAnyBlank(cardId, code, reason)) {
            throw new WxErrorException(WxError.builder().errorCode(41012).errorMsg("参数不完整").build());
        }
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("card_id", cardId);
        jsonRequest.put("code", code);
        jsonRequest.put("reason", reason);
        String response = this.wxMpService.post(CARD_CODE_UNAVAILABLE, JSON.toJSONString(jsonRequest));
        return response;
    }

    public void  test() throws WxErrorException
    {
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("deviceToken", "7005fd697a80afc87b85f10a7a7c2f97024b0d4d30e55733efd31aa23dc80b83");
        jsonRequest.put("uid", 1000241);

        String response = this.wxMpService.get(CARD_CODE_UNAVAILABLE, JSON.toJSONString(jsonRequest));
        System.out.println(response);
    }
}
