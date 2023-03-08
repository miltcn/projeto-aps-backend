package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miltcn.sosti.domain.ServiceOrderMaterial;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class ServiceOrderMaterialDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;

    @NotNull(message = "Required serviceOrderId field")
    private Integer serviceOrderId;
    @NotNull(message = "Required materialId field")
    private Integer materialId;
    @NotNull(message = "Required quantity field")
    private Integer quantity;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    public ServiceOrderMaterialDTO() {
    }

    public ServiceOrderMaterialDTO(Integer id, Integer serviceOrderId, Integer materialId, Integer quantity) {
        this.id = id;
        this.serviceOrderId = serviceOrderId;
        this.materialId = materialId;
        this.quantity = quantity;
    }

    public ServiceOrderMaterialDTO(ServiceOrderMaterial serviceOrderMaterial) {
        this.id = serviceOrderMaterial.getId();
        this.serviceOrderId = serviceOrderMaterial.getServiceOrder().getId();
        this.materialId = serviceOrderMaterial.getMaterial().getId();
        this.quantity = serviceOrderMaterial.getQuantity();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
