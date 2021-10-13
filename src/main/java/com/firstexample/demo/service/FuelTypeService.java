package com.firstexample.demo.service;

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

    public List<FuelType> findAllFuels(){
        return fuelTypeRepository.findAll();
    }

    public FuelType findOneFuel(Long id){
        return fuelTypeRepository.findOneById(id);
    }

    public boolean validateField(FuelType f){
        if(f.getName().trim().equals("")){
            return false;
        }else{
            return true;
        }
    }

    public FuelType saveFuel(FuelType f){
        if(validateField(f)){
            return fuelTypeRepository.save(f);
        }else{
            return null;
        }
    }

    public void deleteOne(Long id){
         fuelTypeRepository.deleteById(id);
    }

    public FuelType updateFuel(Long id, FuelType f){
        FuelType current = fuelTypeRepository.findOneById(id);
        current.setName(f.getName());
        fuelTypeRepository.save(current);
        return current;
    }
}
