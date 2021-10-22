package com.firstexample.demo.repository;

import com.firstexample.demo.model.CarChassis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarChassisRepository extends JpaRepository<CarChassis, Long> {

    CarChassis getCarChassisById(Long id);

    CarChassis save(CarChassis carChassis);

}
