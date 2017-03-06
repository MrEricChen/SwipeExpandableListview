package com.eric.swipe.model;

import java.io.Serializable;

/**
 * @Module :
 * @Comments : 購物車商品实体类
 * @Author : eric.chen
 * @CreateDate : 2016-11-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-11-15
 * @Modified:
 */
public class ShoppingCartProductItemModel implements Serializable {
    private boolean isSelected;
    private boolean available;
    private int inventoryQuantity;
    private int limitMaxl;
    private boolean locked;
    private double originPrice;
    private String productId;
    private String productImage;
    private String productName;
    private double productPrice;
    private int quantity;
    private boolean stage;
    private double subTotal;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public boolean isStage() {
        return stage;
    }

    public void setStage(boolean stage) {
        this.stage = stage;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public int getLimitMaxl() {
        return limitMaxl;
    }

    public void setLimitMaxl(int limitMaxl) {
        this.limitMaxl = limitMaxl;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
