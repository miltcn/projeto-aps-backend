package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.ServiceOrderMaterial;
import com.miltcn.sosti.domain.dtos.ServiceOrderMaterialDTO;
import com.miltcn.sosti.services.ServiceOrderMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamado-materiais")
public class ServiceOrderMaterialController {

    @Autowired
    private ServiceOrderMaterialService serviceOrderMaterialService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderMaterialDTO> findById(@PathVariable Integer id) {
        ServiceOrderMaterial serviceOrderMaterial = this.serviceOrderMaterialService.findById(id);
        return ResponseEntity.ok().body(new ServiceOrderMaterialDTO(serviceOrderMaterial));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderMaterialDTO>> findAll() {
        List<ServiceOrderMaterial> serviceOrderMaterialList = this.serviceOrderMaterialService.findAll();
        List<ServiceOrderMaterialDTO> serviceOrderMaterialDTOList = serviceOrderMaterialList.stream().map(serviceOrderMaterial -> new ServiceOrderMaterialDTO(serviceOrderMaterial)).collect(Collectors.toList());
        return ResponseEntity.ok().body(serviceOrderMaterialDTOList);
    }

    @PostMapping
    public ResponseEntity<ServiceOrderMaterialDTO> create(@Valid @RequestBody ServiceOrderMaterialDTO serviceOrderMaterialDTO) {
        ServiceOrderMaterial serviceOrderMaterial = this.serviceOrderMaterialService.create(serviceOrderMaterialDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(serviceOrderMaterial.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<ServiceOrderMaterialDTO> update(@PathVariable Integer id, @Valid @RequestBody ServiceOrderMaterialDTO serviceOrderMaterialDTO) {
        ServiceOrderMaterial updateServiceOrderMaterial = this.serviceOrderMaterialService.update(id, serviceOrderMaterialDTO);
        return ResponseEntity.ok().body(new ServiceOrderMaterialDTO(updateServiceOrderMaterial));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderMaterialDTO> delete(@PathVariable Integer id) {
        this.serviceOrderMaterialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
