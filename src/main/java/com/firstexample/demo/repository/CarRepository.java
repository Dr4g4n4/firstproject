package com.firstexample.demo.repository;

import com.firstexample.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.brand = :brand")
    Collection<Car> findCarByBrand(@Param("brand") String brand);

    @Query("SELECT c FROM Car c WHERE c.model = :model")
    Collection<Car> findCarByModel(@Param("model") String model);

    @Query("SELECT c FROM Car c WHERE c.mileage > :mileage")
    Collection<Car> findCarByMileageGT(@Param("mileage") int mileage);

    @Query("SELECT c FROM Car c WHERE c.mileage < :mileage")
    Collection<Car> findCarByMileageLT(@Param("mileage") int mileage);

    @Query("SELECT c FROM Car c WHERE c.mileage > :fromMileage AND c.mileage < :toMileage ")
    Collection<Car> findCarByMileageBT(@Param("fromMileage") int fromMileage,@Param("toMileage") int toMileage);

    @Query("SELECT c FROM Car c WHERE c.productionDate > :date")
    Collection<Car> findCarByProductionDateGT(@Param("date") Date date);

    @Query("SELECT c FROM Car c WHERE c.productionDate < :date")
    Collection<Car> findCarByProductionDateLT(@Param("date") Date date);

    @Query("SELECT c FROM Car c WHERE c.productionDate > :fromdate AND c.productionDate< :todate")
    Collection<Car> findCarByProductionDateBT(@Param("fromdate") Date fromdate,@Param("todate") Date todate);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.primaryFuel > :fuel")
    Collection<Car> findCarByFuel(@Param("fuel") String fuel);

}