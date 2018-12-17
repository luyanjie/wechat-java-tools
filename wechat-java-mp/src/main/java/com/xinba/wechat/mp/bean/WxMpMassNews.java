package com.xinba.wechat.common.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/12/17 17:47
 * <p>
 * 群发时用到的图片消息素材
 * <p>
 * TODO WxMpMassNews
 */
@Data
public class WxMpMassNews implements Serializable {
    private static final long serialVersionUID = -1979148653233065162L;

    private List<WxMpMassNewsArticle> articles = new ArrayList<>();

    public void addArticle(WxMpMassNewsArticle article){
        articles.add(article);
    }

    public String toJson(){
        return JSON.toJSONString(this);
    }

    public boolean isEmpty(){
        return this.articles == null || this.articles.isEmpty();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }

    /**
     * <pre>
     * 群发图文消息文章 article.
     * 1. thumbMediaId  (必填) 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * 2. author          图文消息的作者
     * 3. title           (必填) 图文消息的标题
     * 4. contentSourceUrl 在图文消息页面点击“阅读原文”后的页面链接
     * 5. content (必填)  图文消息页面的内容，支持HTML标签
     * 6. digest          图文消息的描述
     * 7, showCoverPic  是否显示封面，true为显示，false为不显示
     * </pre>
     */
    @Data
    public static class WxMpMassNewsArticle {
        /**
         * (必填) 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得.
         */
        private String thumbMediaId;
        /**
         * 图文消息的作者.
         */
        private String author;
        /**
         * (必填) 图文消息的标题.
         */
        private String title;
        /**
         * 在图文消息页面点击“阅读原文”后的页面链接.
         */
        private String contentSourceUrl;
        /**
         * (必填) 图文消息页面的内容，支持HTML标签.
         */
        private String content;
        /**
         * 图文消息的描述.
         */
        private String digest;
        /**
         * 是否显示封面，true为显示，false为不显示.
         */
        private boolean showCoverPic;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }
}
