package com.miltcn.sosti.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomMaterial implements Serializable {
    private static final long serialVersionUID = 1l;

    private String name;
    private BigDecimal price;
    private Integer quantity;

    private Integer serviceOrderMaterialId;

    public CustomMaterial() {
    }

    public CustomMaterial(String name, BigDecimal price, Integer quantity, Integer serviceOrderMaterialId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.serviceOrderMaterialId = serviceOrderMaterialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getServiceOrderMaterialId() {
        return serviceOrderMaterialId;
    }

    public void setServiceOrderMaterialId(Integer serviceOrderMaterialId) {
        this.serviceOrderMaterialId = serviceOrderMaterialId;
    }
}
