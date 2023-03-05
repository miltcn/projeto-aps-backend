package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.domain.enums.Profile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TechnicianDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    protected Integer id;
    protected String name;
    protected String cpf;
    protected String email;
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt;

    public TechnicianDTO() {
        super();
    }

    public TechnicianDTO(Technician technician) {
        super();
        this.id = technician.getId();
        this.name = technician.getName();
        this.cpf = technician.getCpf();
        this.email = technician.getEmail();
        this.password = technician.getPassword();
        this.profiles = technician.getProfiles().stream().map(profile -> profile.getCode()).collect(Collectors.toSet());
        this.createdAt = technician.getCreatedAt();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(profile -> Profile.toEnum(profile)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
