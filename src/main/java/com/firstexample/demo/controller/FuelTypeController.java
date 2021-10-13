package com.firstexample.demo.controller;

import com.firstexample.demo.model.FuelType;
import com.firstexample.demo.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fuel")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FuelType>> getTypes() {
        List<FuelType> fuelTypes = fuelTypeService.findAllFuels();
        if(fuelTypes != null){
            return new ResponseEntity<List<FuelType>>(fuelTypes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuelType> getOne(@PathVariable Long id){
        FuelType ret = fuelTypeService.findOneFuel(id);
        if(ret != null){
            return new ResponseEntity<FuelType>(ret, HttpStatus.OK);
        }else{
             return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping()
    public ResponseEntity<FuelType>  createFuel (@RequestBody FuelType fuel){
        FuelType ret = fuelTypeService.saveFuel(fuel);
        if(ret != null){
            return new ResponseEntity<FuelType>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<FuelType>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        fuelTypeService.deleteOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FuelType> update(@PathVariable Long id, @RequestBody FuelType fuelType){
        FuelType ret = fuelTypeService.updateFuel(id, fuelType);
        if(ret != null){
            return new ResponseEntity<FuelType>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<FuelType>(HttpStatus.FORBIDDEN);
        }
    }

}
