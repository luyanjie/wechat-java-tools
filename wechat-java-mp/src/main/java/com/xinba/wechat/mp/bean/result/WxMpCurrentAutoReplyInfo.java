package com.xinba.wechat.mp.bean.result;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 公众号的自动回复规则.
 * @author jokin
 * @date 2018/12/18 11:52
 *
 */
@Data
public class WxMpCurrentAutoReplyInfo implements Serializable {
  private static final long serialVersionUID = 8294705001262751638L;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static WxMpCurrentAutoReplyInfo fromJson(String json) {
    return JSON.parseObject(json, WxMpCurrentAutoReplyInfo.class);
  }

  @JSONField(name = "is_add_friend_reply_open")
  private Boolean isAddFriendReplyOpen;

  @JSONField(name = "is_autoreply_open")
  private Boolean isAutoReplyOpen;

  @JSONField(name = "add_friend_autoreply_info")
  private AutoReplyInfo addFriendAutoReplyInfo;

  @JSONField(name = "message_default_autoreply_info")
  private AutoReplyInfo messageDefaultAutoReplyInfo;

  @JSONField(name = "keyword_autoreply_info")
  private KeywordAutoReplyInfo keywordAutoReplyInfo;

  @Data
  public static class AutoReplyRule implements Serializable {
    private static final long serialVersionUID = -6415971838145909046L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @JSONField(name = "rule_name")
    private String ruleName;

    @JSONField(name = "create_time")
    private Date createTime;

    @JSONField(name = "reply_mode")
    private String replyMode;

    @JSONField(name = "keyword_list_info")
    private List<KeywordInfo> keywordListInfo;

    @JSONField(name = "reply_list_info")
    private List<ReplyInfo> replyListInfo;

  }

  @Data
  public static class ReplyInfo implements Serializable {
    private static final long serialVersionUID = -3429575601599101690L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    private String type;
    private String content;

    @JSONField(name = "news_info")
    private NewsInfo newsInfo;

  }

  @Data
  public static class NewsInfo implements Serializable {
    private static final long serialVersionUID = 2958827725972593328L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    private List<NewsItem> list;

  }

  @Data
  public static class NewsItem implements Serializable {
    private static final long serialVersionUID = -680356309029767176L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @JSONField(name = "cover_url")
    private String coverUrl;
    private String author;
    @JSONField(name = "content_url")
    private String contentUrl;
    private String digest;
    @JSONField(name = "show_cover")
    private Boolean showCover;
    @JSONField(name = "source_url")
    private String sourceUrl;
    private String title;

  }

  @Data
  public static class KeywordInfo implements Serializable {
    private static final long serialVersionUID = 7720246983986706379L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    private String type;
    @JSONField(name = "match_mode")
    private String matchMode;
    private String content;

  }

  @Data
  public static class KeywordAutoReplyInfo implements Serializable {
    private static final long serialVersionUID = -8789197949404753083L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    private List<AutoReplyRule> list;
  }

  @Data
  public static class AutoReplyInfo implements Serializable {
    private static final long serialVersionUID = 4993719555937843712L;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    private String type;
    private String content;
  }

}
