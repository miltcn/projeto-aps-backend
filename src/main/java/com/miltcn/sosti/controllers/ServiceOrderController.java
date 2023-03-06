package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.dtos.ServiceOrderDTO;
import com.miltcn.sosti.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamados")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderDTO> findById(@PathVariable Integer id) {
        ServiceOrder serviceOrder = this.serviceOrderService.findById(id);
        return ResponseEntity.ok().body(new ServiceOrderDTO(serviceOrder));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderDTO>> findAll() {
        List<ServiceOrder> serviceOrderList = this.serviceOrderService.findAll();
        List<ServiceOrderDTO> serviceOrderDTOList = serviceOrderList.stream().map(serviceOrder -> new ServiceOrderDTO(serviceOrder)).collect(Collectors.toList());
        return ResponseEntity.ok().body(serviceOrderDTOList);
    }
}
