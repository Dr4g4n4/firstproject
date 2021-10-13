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

    public Motor() {
    }

    public Motor(String motorNumber, MotorType motorType) {
        this.motorNumber = motorNumber;
        this.motorType = motorType;
    }
}
