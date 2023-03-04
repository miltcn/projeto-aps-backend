package com.miltcn.sosti.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miltcn.sosti.domain.enums.Priority;
import com.miltcn.sosti.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ServiceOrder implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;
    private Priority priority;
    private Status status;
    private String title;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    public ServiceOrder() {
    }

    public ServiceOrder(Integer id, Priority priority, Status status, String title, String comments, Client client, Technician technician) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.comments = comments;
        this.client = client;
        this.technician = technician;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
}
