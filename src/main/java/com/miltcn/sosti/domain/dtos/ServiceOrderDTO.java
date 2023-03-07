package com.miltcn.sosti.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miltcn.sosti.domain.CustomMaterial;
import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.ServiceOrderMaterial;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ServiceOrderDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;
    @NotNull(message = "priorityCode field is required")
    private Integer priorityCode;
    @NotNull(message = "statusCode field is required")
    private Integer statusCode;
    @NotNull(message = "title field is required")
    private String title;
    @NotNull(message = "comments field is required")
    private String comments;
    @NotNull(message = "clientId field is required")
    private Integer clientId;
    @NotNull(message = "technicianId field is required")
    private Integer technicianId;
    private String clientName;
    private String technicianName;

    @JsonIgnore
    private Set<ServiceOrderMaterial> serviceOrderMaterials;

    private Set<CustomMaterial> customMaterials;

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

        if(serviceOrder.getServiceOrderMaterials() != null) {
            this.customMaterials = serviceOrder.getServiceOrderMaterials().stream().map(x -> buildCustomMaterial(x)).collect(Collectors.toSet());
        }else {
            this.customMaterials = Collections.emptySet();
        }
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

    public Set<ServiceOrderMaterial> getServiceOrderMaterials() {
        return serviceOrderMaterials;
    }

    public Set<CustomMaterial> getCustomMaterials() {
        return customMaterials;
    }

    public void setCustomMaterials(Set<CustomMaterial> customMaterials) {
        this.customMaterials = customMaterials;
    }

    public CustomMaterial buildCustomMaterial(ServiceOrderMaterial serviceOrderMaterial) {
        CustomMaterial customMaterial = new CustomMaterial(
                                                serviceOrderMaterial.getMaterial().getId(),
                                                serviceOrderMaterial.getMaterial().getName(),
                                                serviceOrderMaterial.getMaterial().getPrice(),
                                                serviceOrderMaterial.getQuantity(),
                                                serviceOrderMaterial.getId());
        return customMaterial;
    }
}
