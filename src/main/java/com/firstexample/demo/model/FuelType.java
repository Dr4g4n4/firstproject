package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "FUELTYPE")
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference(value = "fuel_mov")
    @OneToMany(mappedBy = "fuelType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Motor> motors = new HashSet<Motor>();

    public FuelType() {
    }

    public FuelType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
