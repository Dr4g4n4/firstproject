package com.firstexample.demo.repository;

import com.firstexample.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}