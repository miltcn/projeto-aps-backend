package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Person;
import com.miltcn.sosti.domain.Client;
import com.miltcn.sosti.domain.dtos.ClientDTO;
import com.miltcn.sosti.repositories.PersonRepository;
import com.miltcn.sosti.repositories.ClientRepository;
import com.miltcn.sosti.services.exceptions.DataIntegrityViolationException;
import com.miltcn.sosti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Client findById(Integer id) {
        Optional<Client>  obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encotrado! Id: " + id));
    }

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    public Client create(ClientDTO clientDTO) {
        clientDTO.setId(null);
        clientDTO.setPassword(encoder.encode(clientDTO.getPassword()));
        validateByCpfEmail(clientDTO);
        Client client = new Client(clientDTO);
        return this.clientRepository.save(client);
    }

    public Client update(Integer id, ClientDTO clientDTO) {
        clientDTO.setId(id);
        Client oldClient = this.findById(id);
        this.validateByCpfEmail(clientDTO);
        oldClient = new Client(clientDTO);
        return this.clientRepository.save(oldClient);
    }

    public void delete(Integer id) {
        Client client = this.findById(id);
        if(client.getServiceOrders().size() > 0) {
            throw new DataIntegrityViolationException("Não é possível deleter o cliente, pois existem ordens de serviços associadas a ele!");
        }
        this.clientRepository.deleteById(id);
    }

    private void validateByCpfEmail(ClientDTO clientDTO) {
        Optional<Person> person = this.personRepository.findByCpf(clientDTO.getCpf());
        if(person.isPresent() && person.get().getId() != clientDTO.getId()) {
            throw new DataIntegrityViolationException("Já existe um usuário com mesmo CPF cadastrado no sistema!");
        }

        person = this.personRepository.findByEmail(clientDTO.getEmail());
        if(person.isPresent() && person.get().getId() != clientDTO.getId()) {
            throw new DataIntegrityViolationException("Já existe um usuário com mesmo E-mail cadastrado no sistema!");
        }
    }
}
