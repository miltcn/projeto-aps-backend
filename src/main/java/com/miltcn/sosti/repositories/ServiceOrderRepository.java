package com.miltcn.sosti.repositories;

import com.miltcn.sosti.domain.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

}
