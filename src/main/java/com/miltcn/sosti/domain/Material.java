package com.miltcn.sosti.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "material")
@SQLDelete(sql = "UPDATE material SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Material implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private Set<ServiceOrderMaterial> serviceOrderMaterials;

    public Material() {
        super();
    }

    public Material(Integer id, String name, BigDecimal price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<ServiceOrderMaterial> getServiceOrderMaterials() {
        return serviceOrderMaterials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        return id.equals(material.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
