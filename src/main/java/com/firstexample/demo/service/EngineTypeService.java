package com.firstexample.demo.service;

import com.firstexample.demo.datavalidation.RegularExpressions;
import com.firstexample.demo.model.EngineType;
import com.firstexample.demo.repository.EngineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineTypeService {

    @Autowired
    private EngineTypeRepository engineTypeRepository;

    public EngineType getEngineTypeById(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if(engineTypeRepository.existsById(id)){
                return engineTypeRepository.getEngineTypeById(id);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<EngineType> getAllEngineTypes(){ return engineTypeRepository.findAll();}

    public EngineType saveEngineType(EngineType engineType){
        return engineTypeRepository.save(engineType);
    }

    public boolean deleteEngineType(Long id){
        RegularExpressions regularExpressions = new RegularExpressions();
        if(regularExpressions.isIdValid(id)){
            if (engineTypeRepository.existsById(id)) {
                engineTypeRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean validateFields(Long id, EngineType engineType){
        RegularExpressions regularExpressions = new RegularExpressions();
        return regularExpressions.isIdValid(id) && regularExpressions.isValidFuel(engineType.getPrimaryFuel().toString());
    }

    public EngineType updateEngineType(Long id, EngineType engineType){
        if(validateFields(id,engineType)){
            if(engineTypeRepository.existsById(id)){
                EngineType current = engineTypeRepository.getEngineTypeById(id);
                current.setPrimaryFuel(engineType.getPrimaryFuel());
                engineTypeRepository.save(current);
                return current;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
