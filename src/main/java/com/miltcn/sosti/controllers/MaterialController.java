package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.Material;
import com.miltcn.sosti.domain.dtos.MaterialDTO;
import com.miltcn.sosti.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/materiais")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable Integer id) {
        Material material = this.materialService.findById(id);
        return ResponseEntity.ok().body(new MaterialDTO(material));
    }

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll() {
        List<Material> materialList = this.materialService.findAll();
        List<MaterialDTO> materialDTOList = materialList.stream().map(material -> new MaterialDTO(material)).collect(Collectors.toList());
        return ResponseEntity.ok().body(materialDTOList);
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> create(@Valid  @RequestBody MaterialDTO materialDTO) {
        Material material = this.materialService.create(materialDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(material.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> update(@PathVariable Integer id, @Valid @RequestBody MaterialDTO materialDTO) {
        Material updatedMaterial = this.materialService.update(id, materialDTO);
        return ResponseEntity.ok().body(new MaterialDTO(updatedMaterial));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> delete(@PathVariable Integer id) {
        this.materialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
