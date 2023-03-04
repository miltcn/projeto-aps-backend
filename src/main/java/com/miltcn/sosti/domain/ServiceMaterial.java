package com.miltcn.sosti.domain;

public class ServiceMaterial {
    private Integer materialQuantity;

    public ServiceMaterial() {
    }

    public ServiceMaterial(Integer materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public Integer getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(Integer materialQuantity) {
        this.materialQuantity = materialQuantity;
    }
}
