package com.xinba.wechat.mp.bean.datacube;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jokin
 * @date 2018/12/18 11:20
 *
 * 图文分析数据接口返回结果对象.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxDataCubeArticleTotal extends WxDataCubeBaseResult {

    private static final long serialVersionUID = 6424082501342350228L;
    /**
     * msgid.
     * 请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    @JSONField(name = "msgid")
    private String msgId;

    /**
     * title.
     * 图文消息的标题
     */
    private String title;

    /**
     * details.
     * 详细信息
     */
    @JSONField(name ="details")
    private List<WxDataCubeArticleTotalDetail> details;

    public static List<WxDataCubeArticleTotal> fromJson(String json) {

        return JSON.parseObject(JSON.parseObject(json).get("list").toString(),new TypeReference<List<WxDataCubeArticleTotal>>(){});

    }

}