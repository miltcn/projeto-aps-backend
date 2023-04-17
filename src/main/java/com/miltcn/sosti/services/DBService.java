package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.*;
import com.miltcn.sosti.domain.enums.Priority;
import com.miltcn.sosti.domain.enums.Profile;
import com.miltcn.sosti.domain.enums.Status;
import com.miltcn.sosti.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private ServiceOrderMaterialRepository serviceOrderMaterialRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void startDatabase() {

        Technician technician = new Technician(null, "Eduardo Nicolas", "87973255389", "eduardonicolasdamata@zf.com", encoder.encode("123"));
        technician.addProfile(Profile.ADMIN);
        technician.addProfile(Profile.TECHNICIAN);

        Technician technician1 = new Technician(null, "Pedro Fernando Lima", "26454882772", "pedro.fernando.lima@sha.com.br", encoder.encode("123"));
        technician1.addProfile(Profile.TECHNICIAN);
        Technician technician2 = new Technician(null, "Erick Edson Yago Aragão", "36723345533", "erickedsonaragao@outlook.com.br", encoder.encode("123"));
        technician2.addProfile(Profile.TECHNICIAN);
        Technician technician3 = new Technician(null, "Cecília Olivia Assis", "88553538370", "ceciliaoliviaassis@bat.com", encoder.encode("123"));
        technician3.addProfile(Profile.TECHNICIAN);
        Technician technician4 = new Technician(null, "José Arthur Almeida", "29537155501", "jose.arthur.almeida@eletrovip.com", encoder.encode("123"));
        technician4.addProfile(Profile.TECHNICIAN);
        Technician technician5 = new Technician(null, "Bárbara Clarice Joana Dias", "79807605300", "barbara-dias72@demetriushairstudio.com.br", encoder.encode("123"));
        technician5.addProfile(Profile.TECHNICIAN);
        Technician technician6 = new Technician(null, "Augusto Pedro Henrique Julio Farias", "03582902366", "augusto-farias90@homail.com", encoder.encode("123"));
        technician6.addProfile(Profile.TECHNICIAN);
        Technician technician7 = new Technician(null, "Thomas Raul Nunes", "64146421349", "thomas_raul_nunes@technocut.com.br", encoder.encode("123"));
        technician7.addProfile(Profile.TECHNICIAN);
        Technician technician8 = new Technician(null, "Danilo Anderson Nascimento", "72227565314", "danilo_nascimento@inbox.com", encoder.encode("123"));
        technician8.addProfile(Profile.TECHNICIAN);
        Technician technician9 = new Technician(null, "Fabiana Raimunda Viana", "06973710344", "fabiana.raimunda.viana@hotmai.com", encoder.encode("123"));
        technician9.addProfile(Profile.TECHNICIAN);
        Technician technician10 = new Technician(null, "Ruan Breno Pedro Lopes", "31200335376", "ruan.breno.lopes@athoscontabil.com.br", encoder.encode("123"));
        technician10.addProfile(Profile.TECHNICIAN);


        Client client1 = new Client(null, "Ruan Danilo Teixeira", "64861497604", "ruan.danilo.teixeira@tecsysbrasil.com.br", encoder.encode("123"));
        Client client2 = new Client(null, "Francisco Enrico da Mota", "31656351706", "francisco_enrico_damota@prifree.fr", encoder.encode("123"));
        Client client3 = new Client(null, "Eloá Alessandra da Cruz", "19615681601", "eloa-dacruz81@rabelloadvogados.com.br", encoder.encode("123"));


        ServiceOrder serviceOrder1 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 01", "Chamada Teste 01", client1, technician1);
        ServiceOrder serviceOrder2 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 02", "Chamada Teste 02", client2, technician2);
        ServiceOrder serviceOrder3 = new ServiceOrder(null, Priority.ALTA, Status.ABERTO, "Chamado 04", "Chamada Teste 04", client1, technician3);
        ServiceOrder serviceOrder4 = new ServiceOrder(null, Priority.BAIXA, Status.ABERTO, "Chamado 05", "Chamada Teste 05", client2, technician4);
        ServiceOrder serviceOrder5 = new ServiceOrder(null, Priority.BAIXA, Status.ABERTO, "Chamado 06", "Chamada Teste 06", client3, technician5);
        ServiceOrder serviceOrder6 = new ServiceOrder(null, Priority.MEDIA, Status.ENCERRADO, "Chamado 07", "Chamada Teste 07", client1, technician6);
        ServiceOrder serviceOrder7 = new ServiceOrder(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 08", "Chamada Teste 08", client2, technician7);
        ServiceOrder serviceOrder8 = new ServiceOrder(null, Priority.ALTA, Status.ENCERRADO, "Chamado 09", "Chamada Teste 09", client3, technician8);
        ServiceOrder serviceOrder9 = new ServiceOrder(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 03", "Chamada Teste 03", client1, technician9);
        ServiceOrder serviceOrder10 = new ServiceOrder(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 10", "Chamada Teste 10", client2, technician9);

        Material material1 = new Material(null, "SSD 512GB", new BigDecimal("350.00"));
        Material material2 = new Material(null, "Placa de vídeo", new BigDecimal("750.00"));
        Material material3 = new Material(null, "Memória RAM", new BigDecimal("250.00"));

        ServiceOrderMaterial serviceOrderMaterial1 = new ServiceOrderMaterial(null, serviceOrder1, material1, 3);
        ServiceOrderMaterial serviceOrderMaterial2 = new ServiceOrderMaterial(null, serviceOrder1, material2, 3);

        technicianRepository.saveAll(Arrays.asList(
                technician,
                technician1,
                technician2,
                technician3,
                technician4,
                technician5,
                technician6,
                technician7,
                technician8,
                technician9,
                technician10
        ));
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
        serviceOrderRepository.saveAll(Arrays.asList(
                serviceOrder1,
                serviceOrder2,
                serviceOrder3,
                serviceOrder4,
                serviceOrder5,
                serviceOrder6,
                serviceOrder7,
                serviceOrder8,
                serviceOrder9,
                serviceOrder10
        ));
        materialRepository.saveAll(Arrays.asList(material1, material2, material3));
        serviceOrderMaterialRepository.saveAll(Arrays.asList(serviceOrderMaterial1, serviceOrderMaterial2));

    }
}