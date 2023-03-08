package com.miltcn.sosti.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ServiceOrderMaterial implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private Integer quantity;

    public ServiceOrderMaterial() {
    }

    public ServiceOrderMaterial(Integer id, ServiceOrder serviceOrder, Material material, Integer quantity) {
        this.id = id;
        this.serviceOrder = serviceOrder;
        this.material = material;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceOrderMaterial that = (ServiceOrderMaterial) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(serviceOrder, that.serviceOrder)) return false;
        if (!Objects.equals(material, that.material)) return false;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (serviceOrder != null ? serviceOrder.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
