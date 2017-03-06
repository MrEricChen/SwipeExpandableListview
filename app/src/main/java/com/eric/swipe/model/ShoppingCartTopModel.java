package com.eric.swipe.model;

import java.io.Serializable;

/**
 * @Module :
 * @Comments : 購物車实体类--外壳
 * @Author : eric.chen
 * @CreateDate : 2016-11-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-11-15
 * @Modified:
 */
public class ShoppingCartTopModel implements Serializable {
    private ShoppingCartModel data;
    private String type;

    public ShoppingCartModel getData() {
        return data;
    }

    public void setData(ShoppingCartModel data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
