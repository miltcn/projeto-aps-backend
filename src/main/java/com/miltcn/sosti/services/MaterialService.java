package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Material;
import com.miltcn.sosti.domain.ServiceOrderMaterial;
import com.miltcn.sosti.domain.dtos.MaterialDTO;
import com.miltcn.sosti.repositories.MaterialRepository;
import com.miltcn.sosti.services.exceptions.DataIntegrityViolationException;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public Material findById(Integer id) {
        Optional<Material> material = materialRepository.findById(id);
        return material.orElseThrow(() -> new ObjectNotFoundException("Material não entrado! ID: "+ id));
    }

    public List<Material> findAll() {
        return this.materialRepository.findAll();
    }

    public Material create(MaterialDTO materialDTO) {
        materialDTO.setId(null);
        Material material = new Material(materialDTO);
        return this.materialRepository.save(material);
    }

    public Material update(Integer id, MaterialDTO materialDTO) {
        materialDTO.setId(id);
        Material oldMaterial = this.findById(id);
        if (!oldMaterial.getServiceOrderMaterials().isEmpty()) {
            throw new DataIntegrityViolationException("Não é possível atualizar o material porque está incluindo em alguns chamados!");

        }
        Material updateMaterial = new Material(materialDTO);
        return this.materialRepository.save(updateMaterial);
    }

    public void delete(Integer id) {
        Material material = this.findById(id);
        if(!material.getServiceOrderMaterials().isEmpty()) {
            for ( ServiceOrderMaterial serviceOrderMaterial : material.getServiceOrderMaterials()) {
                if(serviceOrderMaterial.getServiceOrder().getStatus().getCode() != 2) {
                    throw new DataIntegrityViolationException("Não é possível deletar o material porque está incluindo em alguns chamados não encerrados!");
                }
            }
        }
        this.materialRepository.deleteById(id);
    }
}
