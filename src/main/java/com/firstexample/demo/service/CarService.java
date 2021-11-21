package com.firstexample.demo.service;


import com.firstexample.demo.datavalidation.RegularExpressions;
import com.firstexample.demo.dto.CarDTO;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.model.CarChassis;
import com.firstexample.demo.model.EngineType;
import com.firstexample.demo.repository.CarChassisRepository;
import com.firstexample.demo.repository.CarRepository;
import com.firstexample.demo.repository.EngineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarChassisRepository carChassisRepository;

    @Autowired
    private EngineTypeRepository engineTypeRepository;

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

    public Car saveCar(CarDTO carDTO){
        Car car = new Car(carDTO.getEngineNumber(),carDTO.getChassisSerialNumber(),carDTO.getBrand(),carDTO.getModel(),carDTO.getProductionDate(),carDTO.getFirstRegistration(),carDTO.getMileage());
        car.setChassis(carChassisRepository.getCarChassisById(carDTO.getChassisId()));
        car.setEngineType(engineTypeRepository.getEngineTypeById(carDTO.getEngineTypeId()));
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
    public Collection<Car> get_on_multiple_params(String brand, String model,Integer year){
        int combination=0;
        if(brand!=null)combination+=1;
        if(model!=null)combination+=2;
        if(year!=null)combination+=4;
        switch (combination){
            case 0:
                return null;
            case 1:
                return getCarsByBrand(brand);
            case 2:
                return getCarByModel(model);
            case 3:
                return getCarByBrandandModel(brand,model);
            case 4:
                return getCarByYear(year);
            case 5:
                return getCarByBrandandYear(brand,year);
            case 6:
                return getCarByModelandYear(model,year);
            case 7:
                return getCarByBrandModelandYear(brand,model,year);
        }
        return null;
    }
    public Collection<Car> getCarByBrandModelandYear(String brand, String model, int year ) {
        String start_date_string = "01-01-"+year;
        String end_date_string = "31-12-"+year;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object

        try {
            Date startDate = formatter.parse(start_date_string);
            Date endDate = formatter.parse(end_date_string);
            return carRepository.findCarByBrandModelYear(brand,model,startDate,endDate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
    public Collection<Car> getCarByModelandYear( String model, int year ){
        String start_date_string = "01-01-"+year;
        String end_date_string = "31-12-"+year;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object

        try {
            Date startDate = formatter.parse(start_date_string);
            Date endDate = formatter.parse(end_date_string);
            return carRepository.findCarByModelandYear(model,startDate,endDate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Collection<Car> getCarByBrandandYear(String brand,  int year ){
        String start_date_string = "01-01-"+year;
        String end_date_string = "31-12-"+year;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object

        try {
            Date startDate = formatter.parse(start_date_string);
            Date endDate = formatter.parse(end_date_string);
            return carRepository.findCarByBrandandYear(brand,startDate,endDate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    public Collection<Car> getCarByBrandandModel(String brand, String model ){
        return carRepository.findCarByBrandandModel(brand,model);
    }
    public Collection<Car> getCarByYear( int year ){
        String start_date_string = "01-01-"+year;
        String end_date_string = "31-12-"+year;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object

        try {
            Date startDate = formatter.parse(start_date_string);
            Date endDate = formatter.parse(end_date_string);
            return carRepository.findCarByYear(startDate,endDate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }





}

