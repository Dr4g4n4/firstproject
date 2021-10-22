package com.firstexample.demo.service;


import com.firstexample.demo.datavalidation.RegularExpressions;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if(carRepository.existsById(id)){
                return carRepository.getCarById(id);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public boolean deleteCar(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if (carRepository.existsById(id)) {
                carRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean validateFields(Long id, Car car){
        RegularExpressions regularExpressions = new RegularExpressions();
        return regularExpressions.isIdValid(id) && regularExpressions.isValidMileage(car.getMileage());
    }

    public Car updateCar(Long id, Car car){
        if(validateFields(id,car)){
            if(carRepository.existsById(id)){
                Car current = carRepository.getCarById(id);
                current.setMileage(car.getMileage());
                carRepository.save(current);
                return current;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<Car> getCarsByParameters(Specification<Car> spec) {
        return carRepository.findAll(spec);
    }

    public Collection<Car> getCarsByBrand(String brand){
        return carRepository.findCarByBrand(brand);
    }


    public Collection<Car> getCarByModel( String brand){
        return carRepository.findCarByModel(brand);
    }



    public Collection<Car> getCarByMileageGT(int mileage){
        return carRepository.findCarByMileageGT(mileage);
    }


    public Collection<Car> getCarByMileageLT(int mileage){
        return carRepository.findCarByMileageLT(mileage);
    }


    public Collection<Car> getCarByMileageBT(int fromMileage, int toMileage){
        return carRepository.findCarByMileageBT(fromMileage,toMileage);
    }





    public Collection<Car> getCarByProductionDateGT(Date date){
        return carRepository.findCarByProductionDateGT(date);
    }


    public Collection<Car> getCarByProductionDateLT( Date date){
        return carRepository.findCarByProductionDateLT(date);
    }


    public Collection<Car> getCarByProductionDateBT(Date fromdate,Date todate){
        return carRepository.findCarByProductionDateBT(fromdate, todate);
    }


    public Collection<Car> getCarByFuel( String fuel){

        return carRepository.findCarByFuel(fuel);
    }


    public Collection<Car> getCarByMotorVolume(int volume){

        return  carRepository.findCarByMotorVolume(volume);
    }

    public Collection<Car> getCarByMotorPowerGT(int mp){

        return carRepository.findCarByMotorPowerGT(mp);
    }

    public Collection<Car> getCarByHorsePowerGT( int hp){

        return carRepository.findCarByHorsePowerGT(hp);
    }

    public Collection<Car> getCarByMotorPowerLT(int mp){

        return  carRepository.findCarByMotorPowerLT(mp);
    }


    public Collection<Car> getCarByHorsePowerLT(int hp){

        return carRepository.findCarByHorsePowerLT(hp);
    }

     public Collection<Car> getCarByMotorPowerBT(int frommp, int tomp){
        return carRepository.findCarByMotorPowerBT(frommp,tomp);
    }


    public Collection<Car> getCarByHorsePowerBT(int fromhp, int tohp){
        return carRepository.findCarByHorsePowerBT(fromhp,tohp);
    }


    public Collection<Car> getCarByColor( String color){

        return carRepository.findCarByColor(color);
    }

}

