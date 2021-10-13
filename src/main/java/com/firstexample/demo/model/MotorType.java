package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstexample.demo.model.enumeration.CylinderType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MOTOR_TYPE")
public class MotorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @ManyToOne(fetch = FetchType.EAGER)
    private FuelType fuelType;

    @JsonManagedReference(value = "motor_mov")
    @OneToMany(mappedBy = "motorType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Motor>motors = new HashSet<Motor>();

    public MotorType() {
    }

    public MotorType(Long id, int motorPower, int hPower, int volume, int numberOfCylinders, CylinderType cylinderType, Set<Car> cars, FuelType fuelType, Set<Motor> motors) {
        this.id = id;
        this.motorPower = motorPower;
        this.hPower = hPower;
        this.volume = volume;
        this.numberOfCylinders = numberOfCylinders;
        this.cylinderType = cylinderType;
        this.cars = cars;
        this.fuelType = fuelType;
        this.motors = motors;
    }
}
