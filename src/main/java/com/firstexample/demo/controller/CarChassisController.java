package com.firstexample.demo.controller;

import com.firstexample.demo.model.CarChassis;
import com.firstexample.demo.service.CarChassisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chassis")
public class CarChassisController {

    @Autowired
    private CarChassisService carChassisService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarChassis>> getCarChassiss() {
        List<CarChassis> carChassiss= carChassisService.getAllCarChassis();
        if(carChassiss != null){
            return new ResponseEntity<List<CarChassis>>(carChassiss, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarChassis> getCarChassis(@PathVariable Long id){
        CarChassis ret = carChassisService.getCarChassisById(id);
        if(ret != null){
            return new ResponseEntity<CarChassis>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping()
    // TODO: da bude ne bude casesensitive za chassisType i color u JSON-u
    public ResponseEntity<CarChassis> createCarChassis(@RequestBody CarChassis CarChassis){
        CarChassis ret = carChassisService.saveCarChassis(CarChassis);
        if(ret != null){
            return new ResponseEntity<CarChassis>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<CarChassis>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCarChassis(@PathVariable Long id){
        if(carChassisService.deleteCarChassis(id)){
            return new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id invalid",HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CarChassis> updateCarChassis(@PathVariable Long id, @RequestBody CarChassis CarChassis){
        CarChassis ret = carChassisService.updateCarChassis(id, CarChassis);
        if(ret != null){
            return new ResponseEntity<CarChassis>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<CarChassis>(HttpStatus.FORBIDDEN);
        }
    }
}
