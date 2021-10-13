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
}
