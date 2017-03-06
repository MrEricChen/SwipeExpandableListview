package com.eric.swipe.model;


import java.io.Serializable;

/**
 * @Module :
 * @Comments : 購物車商品推广实体类
 * @Author : eric.chen
 * @CreateDate : 2016-11-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-11-15
 * @Modified:
 */
public class ShoppingCartPromotionModel implements Serializable {
    private String banner;
    private long beginDate;
    private long endDate;
    private String description = "";
    private String title = "";
    private String template = "";
    private String id = "";
    private String url = "";
    private boolean isSpecial;

    public long getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(long beginDate) {
        this.beginDate = beginDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
