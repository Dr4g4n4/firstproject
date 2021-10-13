package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "chassis_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private ChassisGeneral chassisGeneral;

    @JsonBackReference(value = "car_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private Motor motor;

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

    public Car(Long id, ChassisGeneral chassisGeneral, Motor motor, String brand, String model, Date productionDate, Date firstRegistration, Double mileage) {
        this.id = id;
        this.chassisGeneral = chassisGeneral;
        this.motor = motor;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }
}
