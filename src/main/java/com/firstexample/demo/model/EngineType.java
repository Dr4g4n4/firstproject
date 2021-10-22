package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstexample.demo.model.enumeration.CylinderType;
import com.firstexample.demo.model.enumeration.Fuel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ENGINE_TYPE",  indexes = {
        @Index(name = "idx_volume", columnList = "volume"),
        @Index(name = "idx_motorpower", columnList = "motor_power"),
        @Index(name = "idx_hpower", columnList = "h_power"),
        @Index(name = "idx_fuel", columnList = "primary_fuel")
})
public class EngineType {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "primary_fuel")
    private Fuel primaryFuel;

    @Enumerated(EnumType.STRING)
    @Column(name = "secondary_fuel")
    private Fuel secondaryFuel;

    @JsonManagedReference(value = "engine_mov")
    @OneToMany(mappedBy = "engineType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>();

    public EngineType() {
    }

    public EngineType(Long id, int motorPower, int hPower, int volume, int numberOfCylinders, CylinderType cylinderType, Fuel primaryFuel, Fuel secondaryFuel, Set<Car> cars) {
        this.id = id;
        this.motorPower = motorPower;
        this.hPower = hPower;
        this.volume = volume;
        this.numberOfCylinders = numberOfCylinders;
        this.cylinderType = cylinderType;
        this.primaryFuel = primaryFuel;
        this.secondaryFuel = secondaryFuel;
        this.cars = cars;
    }
}