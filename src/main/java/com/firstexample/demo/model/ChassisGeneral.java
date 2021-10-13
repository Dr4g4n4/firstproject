package com.firstexample.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CHASSIS_GENERAL")
public class ChassisGeneral {

    @Id
    @Column(name = "serial_number")
    private String serialNumber;

    @JsonBackReference(value = "general_mov")
    @ManyToOne(fetch = FetchType.EAGER)
    private CarChassis chassis;

    @JsonManagedReference(value = "chassis_mov")
    @OneToMany(mappedBy = "chassisGeneral", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>();

    public ChassisGeneral(String serialNumber, CarChassis chassis, Set<Car> cars) {
        this.serialNumber = serialNumber;
        this.chassis = chassis;
        this.cars = cars;
    }
}
