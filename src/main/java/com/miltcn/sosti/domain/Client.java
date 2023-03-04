package com.miltcn.sosti.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
