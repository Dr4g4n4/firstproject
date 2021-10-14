package com.firstexample.demo.repository;

import com.firstexample.demo.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {

    List<FuelType> findAll();

    FuelType findOneById(Long id);

    FuelType save(FuelType f);

}
