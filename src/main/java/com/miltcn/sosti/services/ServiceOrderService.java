package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.repositories.ServiceOrderRepository;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder findById(Integer id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        return serviceOrder.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));
    }

    public List<ServiceOrder> findAll() {
        return this.serviceOrderRepository.findAll();
    }
}
