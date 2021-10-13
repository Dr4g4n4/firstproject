package com.firstexample.demo.repository;

import com.firstexample.demo.model.MotorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorTypeRepository extends JpaRepository<MotorType, Long> {
}
