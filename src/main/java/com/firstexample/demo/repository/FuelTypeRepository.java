package com.firstexample.demo.repository;

import com.firstexample.demo.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
}
