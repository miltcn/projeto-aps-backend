package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miltcn.sosti.domain.Client;
import com.miltcn.sosti.domain.enums.Profile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    protected Integer id;
    @NotNull(message = "Required name field")
    protected String name;
    @NotNull(message = "Required cpf field")
    protected String cpf;
    @NotNull(message = "Required email field")
    protected String email;
    @NotNull(message = "Required password field")
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    public ClientDTO() {
        super();
        addProfile(Profile.CLIENT);
    }

    public ClientDTO(Client client) {
        super();
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.profiles = client.getProfiles().stream().map(profile -> profile.getCode()).collect(Collectors.toSet());
        this.createdAt = client.getCreatedAt();
        addProfile(Profile.CLIENT);
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
