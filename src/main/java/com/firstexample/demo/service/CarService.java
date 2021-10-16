package com.firstexample.demo.service;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

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



    public Collection<Car> getCarByMileageGT(int mileage){
        return carrepository.findCarByMileageGT(mileage);
    }


    public Collection<Car> getCarByMileageLT(int mileage){
        return carrepository.findCarByMileageLT(mileage);
    }


    public Collection<Car> getCarByMileageBT(int fromMileage, int toMileage){
        return carrepository.findCarByMileageBT(fromMileage,toMileage);
    }





    public Collection<Car> getCarByProductionDateGT(Date date){
        return carrepository.findCarByProductionDateGT(date);
    }


    public Collection<Car> getCarByProductionDateLT( Date date){
        return carrepository.findCarByProductionDateLT(date);
    }


    public Collection<Car> getCarByProductionDateBT(Date fromdate,Date todate){
        return carrepository.findCarByProductionDateBT(fromdate, todate);
    }


    public Collection<Car> getCarByFuel( String fuel){

        return carrepository.findCarByFuel(fuel);
    }


    public Collection<Car> getCarByMotorVolume(int volume){

        return  carrepository.findCarByMotorVolume(volume);
    }

    public Collection<Car> getCarByMotorPowerGT(int mp){

        return carrepository.findCarByMotorPowerGT(mp);
    }

    public Collection<Car> getCarByHorsePowerGT( int hp){

        return carrepository.findCarByHorsePowerGT(hp);
    }

    public Collection<Car> getCarByMotorPowerLT(int mp){

        return  carrepository.findCarByMotorPowerLT(mp);
    }


    public Collection<Car> getCarByHorsePowerLT(int hp){

        return carrepository.findCarByHorsePowerLT(hp);
    }

     public Collection<Car> getCarByMotorPowerBT(int frommp, int tomp){
        return carrepository.findCarByMotorPowerBT(frommp,tomp);
    }


    public Collection<Car> getCarByHorsePowerBT(int fromhp, int tohp){
        return carrepository.findCarByHorsePowerBT(fromhp,tohp);
    }


    public Collection<Car> getCarByColor( String color){

        return carrepository.findCarByColor(color);
    }



}
