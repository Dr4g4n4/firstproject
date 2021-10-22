package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstexample.demo.model.enumeration.ChasissType;
import com.firstexample.demo.model.enumeration.Color;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CARCHASSIS",  indexes = {
        @Index(name = "idx_color", columnList = "color")
})
public class CarChassis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "chasiss_type")
    private ChasissType chasissType;

    @Column(name = "length")
    private int length;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "volume")
    private int volume;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @JsonManagedReference(value = "chassis_mov")
    @OneToMany(mappedBy = "chassis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>();

    public CarChassis() {
    }

    public CarChassis(Long id, ChasissType chasissType, int length, int width, int height, int volume, Color color, Set<Car> cars) {
        this.id = id;
        this.chasissType = chasissType;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.color = color;
        this.cars = cars;
    }
}