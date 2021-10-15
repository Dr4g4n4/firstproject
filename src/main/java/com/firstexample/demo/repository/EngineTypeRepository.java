package com.firstexample.demo.repository;

import com.firstexample.demo.model.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {

    EngineType getEngineTypeById(Long id);
}
