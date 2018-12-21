package com.xinba.wechat.mp.bean.material;

import lombok.Data;

import java.io.Serializable;

@Data
public class WxMpMaterialArticleUpdate extends AbstractMediaBean implements Serializable {
  private static final long serialVersionUID = -7611963949517780270L;

  private String mediaId;
  private int index;
  private WxMpMaterialNews.WxMpMaterialNewsArticle articles;

}
