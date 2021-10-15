package com.firstexample.demo.service;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarService {
    private final CarRepository carrepository;


    @Autowired
    public CarService(CarRepository carrepository) {
        this.carrepository = carrepository;
    }

    public Collection<Car> getCarsByBrand(String brand){
        return carrepository.findCarByBrand(brand);
    }


    public Collection<Car> getCarByModel( String brand){
        return carrepository.findCarByModel(brand);
    }



    public Collection<Car> findCarByMileageGT(int mileage){
        return carrepository.findCarByMileageGT(mileage);
    }


    public Collection<Car> findCarByMileageLT(int mileage){
        return carrepository.findCarByMileageLT(mileage);
    }


    public Collection<Car> findCarByMileageBT(int fromMileage, int toMileage){
        return carrepository.findCarByMileageBT(fromMileage,toMileage);
    }





}
