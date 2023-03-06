package com.miltcn.sosti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miltcn.sosti.domain.dtos.ClientDTO;
import com.miltcn.sosti.domain.enums.Profile;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Client extends Person {
    private static final long serialVersionUID = 1l;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Client() {
        super();
        addProfile(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.CLIENT);
    }

    public Client(ClientDTO clientDTO) {
        super();
        this.id = clientDTO.getId();
        this.name = clientDTO.getName();
        this.cpf = clientDTO.getCpf();
        this.email = clientDTO.getEmail();
        this.password = clientDTO.getPassword();
        this.profiles = clientDTO.getProfiles().stream().map(profile -> profile.getCode()).collect(Collectors.toSet());
        this.createdAt = clientDTO.getCreatedAt();
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
