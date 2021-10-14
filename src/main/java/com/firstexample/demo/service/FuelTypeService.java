package com.firstexample.demo.service;

import com.firstexample.demo.datavalidation.RegularExpressions;
import com.firstexample.demo.model.FuelType;
import com.firstexample.demo.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;


    public boolean validateFields(Long id, FuelType f){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id) && regularExpressions.isValidSomeName((f.getName()))){
            return true;
        }else{
            return false;
        }
    }

    public List<FuelType> findAllFuels(){
        return fuelTypeRepository.findAll();
    }

    public FuelType findOneFuel(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if(fuelTypeRepository.existsById(id)){
                return fuelTypeRepository.findOneById(id);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public FuelType saveFuel(FuelType f){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isValidSomeName(f.getName())){
            return fuelTypeRepository.save(f);
        }else{
            return null;
        }
    }

    public boolean deleteOne(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if (fuelTypeRepository.existsById(id)) {
                fuelTypeRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public FuelType updateFuel(Long id, FuelType f){
        if(validateFields(id,f)){
            if(fuelTypeRepository.existsById(id)){
                FuelType current = fuelTypeRepository.findOneById(id);
                current.setName(f.getName());
                fuelTypeRepository.save(current);
                return current;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
