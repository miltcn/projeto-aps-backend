package com.miltcn.sosti.domain;

import java.math.BigDecimal;

public class Material {
    private Integer id;
    private String name;
    private BigDecimal value;

    public Material() {
    }

    public Material(Integer id, String name, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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
