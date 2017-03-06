package com.eric.swipe.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Module :
 * @Comments : 購物車实体类
 * @Author : eric.chen
 * @CreateDate : 2016-11-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-11-15
 * @Modified:
 */
public class ShoppingCartModel implements Serializable {
    private int quantity;
    private double amount;
    private double discount;
    private String message;
    private List<ShoppingCartProductModel> sections;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<ShoppingCartProductModel> getSections() {
        return sections;
    }

    public void setSections(List<ShoppingCartProductModel> sections) {
        this.sections = sections;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
