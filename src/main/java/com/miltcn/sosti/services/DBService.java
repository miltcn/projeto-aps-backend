package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Client;
import com.miltcn.sosti.domain.ServiceOrder;
import com.miltcn.sosti.domain.Technician;
import com.miltcn.sosti.domain.enums.Priority;
import com.miltcn.sosti.domain.enums.Profile;
import com.miltcn.sosti.domain.enums.Status;
import com.miltcn.sosti.repositories.ClientRepository;
import com.miltcn.sosti.repositories.ServiceOrderRepository;
import com.miltcn.sosti.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public void startDatabase() {
        Technician technician1 = new Technician(null, "Pedro Fernando Lima", "26454882772", "pedro.fernando.lima@sha.com.br", "123");
        technician1.addProfile(Profile.TECHNICIAN);

        Client client1 = new Client(null, "Ruan Danilo Teixeira", "64861497604", "ruan.danilo.teixeira@tecsysbrasil.com.br", "123");
//		client1.addProfile(Profile.CLIENT);

        ServiceOrder serviceOrder1 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 01", "Chamada Teste 01", client1, technician1);

        technicianRepository.saveAll(Arrays.asList(technician1));
        clientRepository.saveAll(Arrays.asList(client1));
        serviceOrderRepository.saveAll(Arrays.asList(serviceOrder1));
    }
}