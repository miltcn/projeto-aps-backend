package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Material;
import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.ServiceOrderMaterial;
import com.miltcn.sosti.domain.dtos.ServiceOrderMaterialDTO;
import com.miltcn.sosti.repositories.ServiceOrderMaterialRepository;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderMaterialService {

    @Autowired
    private ServiceOrderMaterialRepository serviceOrderMaterialRepository;
    @Autowired
    private ServiceOrderService serviceOrderService;
    @Autowired
    private MaterialService materialService;

    public ServiceOrderMaterial findById(Integer id) {
        Optional<ServiceOrderMaterial> serviceOrderMaterial = this.serviceOrderMaterialRepository.findById(id);
        return serviceOrderMaterial.orElseThrow(() -> new ObjectNotFoundException("Não exsite materias associados a ordem de serviço de ID: "+ id));
    }

    public List<ServiceOrderMaterial> findAll() {
        return this.serviceOrderMaterialRepository.findAll();
    }

    public ServiceOrderMaterial create(ServiceOrderMaterialDTO serviceOrderMaterialDTO) {
        ServiceOrder serviceOrder = this.serviceOrderService.findById(serviceOrderMaterialDTO.getServiceOrderId());
        Material material = this.materialService.findById(serviceOrderMaterialDTO.getMaterialId());
        ServiceOrderMaterial serviceOrderMaterial = new ServiceOrderMaterial(null, serviceOrder, material, serviceOrderMaterialDTO.getQuantity());
        return serviceOrderMaterialRepository.save(serviceOrderMaterial);
    }

    public ServiceOrderMaterial update(Integer id, ServiceOrderMaterialDTO serviceOrderMaterialDTO) {
        serviceOrderMaterialDTO.setId(id);
        ServiceOrderMaterial oldServiceOrderMaterial = this.findById(id);
        ServiceOrder serviceOrder = this.serviceOrderService.findById(serviceOrderMaterialDTO.getServiceOrderId());
        Material material = this.materialService.findById(serviceOrderMaterialDTO.getMaterialId());
        oldServiceOrderMaterial.setServiceOrder(serviceOrder);
        oldServiceOrderMaterial.setMaterial(material);
        oldServiceOrderMaterial.setQuantity(serviceOrderMaterialDTO.getQuantity());
        return this.serviceOrderMaterialRepository.save(oldServiceOrderMaterial);
    }

    public void delete(Integer id) {
        this.findById(id);
        this.serviceOrderMaterialRepository.deleteById(id);
    }
}
