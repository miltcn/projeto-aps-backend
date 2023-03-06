package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miltcn.sosti.domain.ServiceOrder;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceOrderDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;
    private Integer priorityCode;
    private Integer statusCode;
    private String title;
    private String comments;
    private Integer clientId;
    private Integer technicianId;
    private String clientName;
    private String technicianName;

    public ServiceOrderDTO() {
        super();
    }

    public ServiceOrderDTO(ServiceOrder serviceOrder) {
        super();
        this.id = serviceOrder.getId();
        this.openingDate = serviceOrder.getOpeningDate();
        this.closingDate = serviceOrder.getClosingDate();
        this.priorityCode = serviceOrder.getPriority().getCode();
        this.statusCode = serviceOrder.getStatus().getCode();
        this.title = serviceOrder.getTitle();
        this.comments = serviceOrder.getComments();
        this.clientId = serviceOrder.getClient().getId();
        this.technicianId = serviceOrder.getTechnician().getId();
        this.clientName = serviceOrder.getClient().getName();
        this.technicianName = serviceOrder.getTechnician().getName();
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

    public Integer getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(Integer priorityCode) {
        this.priorityCode = priorityCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
}
