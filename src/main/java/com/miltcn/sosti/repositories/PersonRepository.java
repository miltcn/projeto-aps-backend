package com.miltcn.sosti.repositories;

import com.miltcn.sosti.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
