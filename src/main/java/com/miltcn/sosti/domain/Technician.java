package com.miltcn.sosti.domain;

import java.util.ArrayList;
import java.util.List;

public class Technician extends Person {
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician() {
        super();
    }

    public Technician(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}