package com.miltcn.sosti.controllers;

import com.miltcn.sosti.domain.Client;
import com.miltcn.sosti.domain.dtos.ClientDTO;
import com.miltcn.sosti.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) {
        Client obj = this.clientService.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> listClient = this.clientService.findAll();
        List<ClientDTO> listClientDTO = listClient.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listClientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = this.clientService.create(clientDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO clientDTO) {
        Client updatedClient = this.clientService.update(id, clientDTO);
        return ResponseEntity.ok().body(new ClientDTO(updatedClient));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Integer id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
