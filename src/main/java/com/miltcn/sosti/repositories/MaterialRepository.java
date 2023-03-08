package com.miltcn.sosti.repositories;

import com.miltcn.sosti.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
