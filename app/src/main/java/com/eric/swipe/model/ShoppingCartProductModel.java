package com.eric.swipe.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Module :
 * @Comments : 購物車商品实体类
 * @Author : eric.chen
 * @CreateDate : 2016-11-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-11-15
 * @Modified:
 */
public class ShoppingCartProductModel implements Serializable {
    private ShoppingCartPromotionModel promotion;
    private double total;
    private double discount;
    private boolean satisfaction;
    private List<ShoppingCartProductItemModel> items;

    public ShoppingCartPromotionModel getPromotion() {
        return promotion;
    }

    public void setPromotion(ShoppingCartPromotionModel promotion) {
        this.promotion = promotion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(boolean satisfaction) {
        this.satisfaction = satisfaction;
    }

    public List<ShoppingCartProductItemModel> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartProductItemModel> items) {
        this.items = items;
    }
}
