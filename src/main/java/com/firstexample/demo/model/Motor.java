package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "MOTOR")
public class Motor {

    @Id
    @Column(name = "motor_number")
    private String motorNumber;

    @JsonBackReference(value = "motor_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private MotorType motorType;

    @JsonBackReference(value = "fuel_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private FuelType fuelType;

    public Motor() {
    }

    public Motor(String motorNumber, MotorType motorType, FuelType fuelType) {
        this.motorNumber = motorNumber;
        this.motorType = motorType;
        this.fuelType = fuelType;
    }
}
