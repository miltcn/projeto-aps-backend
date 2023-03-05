package com.miltcn.sosti.repositories;

import com.miltcn.sosti.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
