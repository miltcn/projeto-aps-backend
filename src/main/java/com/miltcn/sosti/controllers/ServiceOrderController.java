package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.dtos.ServiceOrderDTO;
import com.miltcn.sosti.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ServiceOrderDTO> create(@Valid @RequestBody ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder serviceOrder = this.serviceOrderService.create(serviceOrderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(serviceOrder.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderDTO> update(@PathVariable Integer id, @Valid @RequestBody ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder newServiceOrder = this.serviceOrderService.update(id, serviceOrderDTO);
        return ResponseEntity.ok().body(new ServiceOrderDTO(newServiceOrder));
    }
}
