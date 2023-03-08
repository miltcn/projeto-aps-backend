package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miltcn.sosti.domain.Material;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MaterialDTO {

    private Integer id;
    @NotNull(message = "Required name field")
    private String name;
    @NotNull(message = "Required price field")
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    private boolean deleted;


    public MaterialDTO() {
    }

    public MaterialDTO(Integer id, String name, BigDecimal price, LocalDate createdAt, boolean deleted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
        this.deleted = deleted;
    }

    public MaterialDTO(Material material) {
        this.id = material.getId();
        this.name = material.getName();
        this.price = material.getPrice();
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
}
