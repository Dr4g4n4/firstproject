package com.firstexample.demo.repository;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {

    Car getCarById(Long id);

    Car save(Car car);
}