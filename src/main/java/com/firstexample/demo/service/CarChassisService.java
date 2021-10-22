package com.firstexample.demo.service;

import com.firstexample.demo.datavalidation.RegularExpressions;
import com.firstexample.demo.model.CarChassis;
import com.firstexample.demo.repository.CarChassisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarChassisService {

    @Autowired
    private CarChassisRepository carChassisRepository;

    public CarChassis getCarChassisById(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if(carChassisRepository.existsById(id)){
                return carChassisRepository.getCarChassisById(id);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<CarChassis> getAllCarChassis() { return carChassisRepository.findAll();}

    public CarChassis saveCarChassis(CarChassis carChassis){
        return carChassisRepository.save(carChassis);
    }

    public boolean deleteCarChassis(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if (carChassisRepository.existsById(id)) {
                carChassisRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean validateFields(Long id, CarChassis carChassis){
        RegularExpressions regularExpressions = new RegularExpressions();
        return regularExpressions.isIdValid(id) && regularExpressions.isValidColor(carChassis.getColor().toString());
    }

    public CarChassis updateCarChassis(Long id, CarChassis carChassis){
        if(validateFields(id,carChassis)){
            if(carChassisRepository.existsById(id)){
                CarChassis current = carChassisRepository.getCarChassisById(id);
                current.setColor(carChassis.getColor());
                carChassisRepository.save(current);
                return current;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
