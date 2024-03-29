package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Client;
import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.domain.dtos.ServiceOrderDTO;
import com.miltcn.sosti.domain.enums.Priority;
import com.miltcn.sosti.domain.enums.Status;
import com.miltcn.sosti.repositories.ServiceOrderRepository;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;
    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ClientService clientService;

    public ServiceOrder findById(Integer id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        return serviceOrder.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));
    }

    public List<ServiceOrder> findAll() {
        return this.serviceOrderRepository.findAll();
    }

    public ServiceOrder create(ServiceOrderDTO serviceOrderDTO) {
        return this.serviceOrderRepository.save(this.newServiceOrder(serviceOrderDTO));
    }

    public ServiceOrder update(Integer id, ServiceOrderDTO serviceOrderDTO) {
        serviceOrderDTO.setId(id);
        this.findById(id);
        ServiceOrder oldServiceOrder = this.newServiceOrder(serviceOrderDTO);
        return this.serviceOrderRepository.save(oldServiceOrder);
    }

    public ServiceOrder newServiceOrder(ServiceOrderDTO serviceOrderDTO) {

        Technician technician = this.technicianService.findById(serviceOrderDTO.getTechnicianId());
        Client client = this.clientService.findById(serviceOrderDTO.getClientId());

        ServiceOrder serviceOrder = new ServiceOrder();
        if(serviceOrderDTO.getId() != null) {
            serviceOrder.setId(serviceOrderDTO.getId());
        }

        if(serviceOrderDTO.getStatusCode().equals(2)) {
            serviceOrder.setClosingDate(LocalDate.now());
        }

        serviceOrder.setTechnician(technician);
        serviceOrder.setClient(client);
        serviceOrder.setPriority(Priority.toEnum(serviceOrderDTO.getPriorityCode()));
        serviceOrder.setStatus(Status.toEnum(serviceOrderDTO.getStatusCode()));
        serviceOrder.setTitle(serviceOrderDTO.getTitle());
        serviceOrder.setComments(serviceOrderDTO.getComments());

        return serviceOrder;
    }
}
