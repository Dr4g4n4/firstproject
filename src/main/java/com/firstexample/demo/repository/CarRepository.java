package com.firstexample.demo.repository;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {

    Car getCarById(Long id);

    Car save(Car car);
  
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

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.primaryFuel = :fuel")
    Collection<Car> findCarByFuel(@Param("fuel") String fuel);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.volume = :volume")
    Collection<Car> findCarByMotorVolume(@Param("volume") int volume);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.motorPower > :mp")
    Collection<Car> findCarByMotorPowerGT(@Param("mp") int mp);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.hPower > :hp")
    Collection<Car> findCarByHorsePowerGT(@Param("hp") int hp);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.motorPower < :mp")
    Collection<Car> findCarByMotorPowerLT(@Param("mp") int mp);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.hPower < :hp")
    Collection<Car> findCarByHorsePowerLT(@Param("hp") int hp);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.motorPower > :frommp and e.motorPower< :tomp")
    Collection<Car> findCarByMotorPowerBT(@Param("frommp") int frommp,@Param("tomp") int tomp);

    @Query("SELECT c FROM Car c join EngineType e on (c.engineType.id= e.id) where e.hPower > :fromhp and e.motorPower< :tohp")
    Collection<Car> findCarByHorsePowerBT(@Param("fromhp") int fromhp,@Param("tohp") int tohp);


    @Query("SELECT c FROM Car c join CarChassis cc on (c.chassis.id= cc.id) where cc.color = :color")
    Collection<Car> findCarByColor(@Param("color") String color);

    @Query(value = "SELECT c FROM Car c WHERE c.brand = :brand and c.model= :model and c.productionDate >= :startDate and c.productionDate <= :endDate")
    Collection<Car> findCarByBrandModelYear(@Param("brand") String brand,@Param("model") String model,@Param("startDate") Date startDate,@Param("endDate") Date endDate );

    @Query(value = "SELECT c FROM Car c WHERE c.brand = :brand and c.model= :model and c.productionDate >= :startDate and c.productionDate <= :endDate")
    Collection<Car> findCarByModelandYear(@Param("model") String model,@Param("startDate") Date startDate,@Param("endDate") Date endDate );

    @Query(value = "SELECT c FROM Car c WHERE c.brand = :brand and c.model= :model and c.productionDate >= :startDate and c.productionDate <= :endDate")
    Collection<Car> findCarByBrandandYear(@Param("brand") String brand,@Param("startDate") Date startDate,@Param("endDate") Date endDate );

    @Query(value = "SELECT c FROM Car c WHERE c.brand = :brand and c.model= :model ")
    Collection<Car> findCarByBrandandModel(@Param("brand") String brand,@Param("model") String model );

    @Query(value = "SELECT c FROM Car c WHERE c.productionDate >= :startDate and c.productionDate <= :endDate")
    Collection<Car> findCarByYear(@Param("startDate") Date startDate,@Param("endDate") Date endDate );

}