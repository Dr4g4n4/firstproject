package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstexample.demo.model.enumeration.CylinderType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MOTOR")
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "motor_number")
    private String motorNumber;

    @Column(name = "motor_power")
    private int motorPower;

    @Column(name = "h_power")
    private int hPower;

    @Column(name = "volume")
    private int volume;

    @Column(name = "number_of_cylinders")
    private int numberOfCylinders;

    @Enumerated(EnumType.STRING)
    @Column(name = "cylinder_type")
    private CylinderType cylinderType;

    @JsonManagedReference(value = "car_mov")
    @OneToMany(mappedBy = "motor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>();

    @JsonBackReference(value = "fuel_mov")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FuelType fuelType;

    public Motor() {
    }

    public Motor(Long id, String motorNumber, int motorPower, int hPower, int volume, int numberOfCylinders, CylinderType cylinderType, FuelType fuelType, Set<Car> cars) {
        this.id = id;
        this.motorNumber = motorNumber;
        this.motorPower = motorPower;
        this.hPower = hPower;
        this.volume = volume;
        this.numberOfCylinders = numberOfCylinders;
        this.cylinderType = cylinderType;
        this.fuelType = fuelType;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotorNumber() {
        return motorNumber;
    }

    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }

    public int gethPower() {
        return hPower;
    }

    public void sethPower(int hPower) {
        this.hPower = hPower;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public CylinderType getCylinderType() {
        return cylinderType;
    }

    public void setCylinderType(CylinderType cylinderType) {
        this.cylinderType = cylinderType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
