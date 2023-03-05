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
        Technician technician2 = new Technician(null, "Erick Edson Yago Aragão", "36723345533", "erickedsonaragao@outlook.com.br", "123");
        technician2.addProfile(Profile.TECHNICIAN);
        Technician technician3 = new Technician(null, "Cecília Olivia Assis", "29537155501", "ceciliaoliviaassis@bat.com", "123");
        technician3.addProfile(Profile.TECHNICIAN);


        Client client1 = new Client(null, "Ruan Danilo Teixeira", "64861497604", "ruan.danilo.teixeira@tecsysbrasil.com.br", "123");
        Client client2 = new Client(null, "Francisco Enrico da Mota", "31656351706", "francisco_enrico_damota@prifree.fr", "123");
        Client client3 = new Client(null, "Eloá Alessandra da Cruz", "19615681601", "eloa-dacruz81@rabelloadvogados.com.br", "123");


        ServiceOrder serviceOrder1 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 01", "Chamada Teste 01", client1, technician1);
        ServiceOrder serviceOrder2 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 02", "Chamada Teste 02", client2, technician2);
        ServiceOrder serviceOrder3 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 03", "Chamada Teste 03", client3, technician3);

        technicianRepository.saveAll(Arrays.asList(technician1, technician2, technician3));
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
        serviceOrderRepository.saveAll(Arrays.asList(serviceOrder1, serviceOrder2, serviceOrder3));

    }
}
