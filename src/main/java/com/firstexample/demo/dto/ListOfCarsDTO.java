package com.firstexample.demo.dto;

import com.firstexample.demo.model.Car;

import java.util.List;

public class ListOfCarsDTO {
    List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
