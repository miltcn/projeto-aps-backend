package com.miltcn.sosti.domain;

import com.miltcn.sosti.domain.enums.Priority;
import com.miltcn.sosti.domain.enums.Status;

import java.time.LocalDate;

public class ServiceOrder {
    private Integer id;
    private LocalDate openingDate = LocalDate.now();
    private LocalDate closingDate;
    private Priority priority;
    private Status status;
    private String title;
    private String comments;
    private Client client;
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
