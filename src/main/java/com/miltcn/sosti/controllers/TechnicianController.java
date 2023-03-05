package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.domain.dtos.TechnicianDTO;
import com.miltcn.sosti.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
        Technician obj = this.technicianService.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll() {
        List<Technician> listTechnician = this.technicianService.findAll();
        List<TechnicianDTO> listTechnicianDTO = listTechnician.stream().map(technician -> new TechnicianDTO(technician)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listTechnicianDTO);
    }
}
