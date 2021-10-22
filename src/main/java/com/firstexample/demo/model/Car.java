package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "CAR", indexes = {
        @Index(name = "idx_engine_number", columnList = "engine_number"),
        @Index(name = "idx_engine_type", columnList = "engine_type_id"),
        @Index(name = "idx_chassis_number", columnList = "chassis_serial_number"),
        @Index(name = "idx_brand", columnList = "brand"),
        @Index(name = "idx_model", columnList = "model"),
        @Index(name = "idx_chassis", columnList = "chassis_id"),
        @Index(name = "idx_mileage", columnList = "mileage"),
        @Index(name = "idx_productiondate", columnList = "production_date"),
        // @Index(name = "idx_mileagebrand", columnList = "mileage, brand"),
        // @Index(name = "idx_brand_model", columnList = "brand, model")
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "engine_number")
    private String engineNumber;

    @JsonBackReference(value = "engine_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private EngineType engineType;

    @Column(name = "chassis_serial_number")
    private String chassisSerialNumber;

    @JsonBackReference(value = "chassis_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private CarChassis chassis;

    @Column(name= "brand")
    private String brand;

    @Column(name= "model")
    private String model;

    @Column(name= "production_date")
    private Date productionDate;

    @Column(name= "first_registration")
    private Date firstRegistration;

    @Column(name= "mileage")
    private Double mileage;

    public Car() {
    }

    public Car(Long id, String engineNumber, EngineType engineType, String chassisSerialNumber, CarChassis chassis, String brand, String model, Date productionDate, Date firstRegistration, Double mileage) {
        this.id = id;
        this.engineNumber = engineNumber;
        this.engineType = engineType;
        this.chassisSerialNumber = chassisSerialNumber;
        this.chassis = chassis;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }

    public Car(String engineNumber, String chassisSerialNumber, String brand, String model, Date productionDate, Date firstRegistration, Double mileage) {
        this.engineNumber = engineNumber;
        this.chassisSerialNumber = chassisSerialNumber;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }

}