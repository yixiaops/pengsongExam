package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.List;

public class Goods {
    private String productNo;
    private String productName;
    private BigDecimal discount;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    private List<Action> actions;



    public Goods(String productNo, String productName, BigDecimal discount, String productType, BigDecimal price) {
        this.productNo = productNo;
        this.productName = productName;
        this.discount = discount;
        this.productType = productType;
        this.price = price;
    }

    private String productType;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


}
