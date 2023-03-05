package com.miltcn.sosti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miltcn.sosti.domain.dtos.TechnicianDTO;
import com.miltcn.sosti.domain.enums.Profile;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Technician extends Person {
    private static final long serialVersionUID = 1l;

    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician() {
        super();
        addProfile(Profile.CLIENT);
    }

    public Technician(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.CLIENT);
    }

    public Technician(TechnicianDTO technicianDTO) {
        super();
        this.id = technicianDTO.getId();
        this.name = technicianDTO.getName();
        this.cpf = technicianDTO.getCpf();
        this.email = technicianDTO.getEmail();
        this.password = technicianDTO.getPassword();
        this.profiles = technicianDTO.getProfiles().stream().map(profile -> profile.getCode()).collect(Collectors.toSet());
        this.createdAt = technicianDTO.getCreatedAt();
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
