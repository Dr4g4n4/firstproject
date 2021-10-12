package com.firstexample.demo.repository;

import com.firstexample.demo.model.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorRepository extends JpaRepository<Motor, Long> {
}
