package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "chassis_mov")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CarChassis carChassis;

    @JsonBackReference(value = "car_mov")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Car(Long id, CarChassis carChassis, Motor motor, String brand, String model, Date productionDate, Date firstRegistration, Double mileage) {
        this.id = id;
        this.carChassis = carChassis;
        this.motor = motor;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarChassis getCarChassis() {
        return carChassis;
    }

    public void setCarChassis(CarChassis carChassis) {
        this.carChassis = carChassis;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(Date firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
}
