package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Person;
import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.domain.dtos.TechnicianDTO;
import com.miltcn.sosti.domain.enums.Profile;
import com.miltcn.sosti.repositories.PersonRepository;
import com.miltcn.sosti.repositories.TechnicianRepository;
import com.miltcn.sosti.services.exceptions.DataIntegrityViolationException;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Technician findById(Integer id) {
        Optional<Technician>  obj = technicianRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico não encotrado! Id: " + id));
    }

    public List<Technician> findAll() {
        return this.technicianRepository.findAll();
    }

    public Technician create(TechnicianDTO technicianDTO) {
        technicianDTO.setId(null);
        technicianDTO.setPassword(encoder.encode(technicianDTO.getPassword()));
        validateByCpfEmail(technicianDTO);
        if(!technicianDTO.getProfiles().contains(Profile.CLIENT)){
            technicianDTO.addProfile(Profile.CLIENT);
        }
        Technician technician = new Technician(technicianDTO);
        return this.technicianRepository.save(technician);
    }

    public Technician update(Integer id, TechnicianDTO technicianDTO) {
        technicianDTO.setId(id);
        Technician oldTechnician = this.findById(id);
        this.validateByCpfEmail(technicianDTO);
        if(!technicianDTO.getPassword().equals(oldTechnician.getPassword())){
            technicianDTO.setPassword(encoder.encode(technicianDTO.getPassword()));
        }
        oldTechnician = new Technician(technicianDTO);
        return this.technicianRepository.save(oldTechnician);
    }

    public void delete(Integer id) {
        Technician technician = this.findById(id);
        if(!technician.getServiceOrders().isEmpty()) {
            throw new DataIntegrityViolationException("Não é possível deleter o técnico, pois existem ordens de serviços associadas a ele!");
        }
        this.technicianRepository.deleteById(id);
    }

    private void validateByCpfEmail(TechnicianDTO technicianDTO) {
        Optional<Person> person = this.personRepository.findByCpf(technicianDTO.getCpf());
        if(person.isPresent() && !person.get().getId().equals(technicianDTO.getId())) {
            throw new DataIntegrityViolationException("Já existe um usuário com mesmo CPF cadastrado no sistema!");
        }

        person = this.personRepository.findByEmail(technicianDTO.getEmail());
        if(person.isPresent() && !person.get().getId().equals(technicianDTO.getId())) {
            throw new DataIntegrityViolationException("Já existe um usuário com mesmo E-mail cadastrado no sistema!");
        }
    }
}
