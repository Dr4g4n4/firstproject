package com.firstexample.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstexample.demo.model.enumeration.ChasissType;
import com.firstexample.demo.model.enumeration.Color;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CARCHASSIS")
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
    @OneToMany(mappedBy = "carChassis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChasissType getChasissType() {
        return chasissType;
    }

    public void setChasissType(ChasissType chasissType) {
        this.chasissType = chasissType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
