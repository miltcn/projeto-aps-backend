package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.repositories.TechnicianRepository;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician findById(Integer id) {
        Optional<Technician>  obj = technicianRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico não encotrado! Id: " + id));
    }

    public List<Technician> findAll() {
        return this.technicianRepository.findAll();
    }
}
