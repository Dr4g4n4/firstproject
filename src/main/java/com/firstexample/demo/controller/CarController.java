package com.firstexample.demo.controller;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars= carService.getAllCars();
        if(cars != null){
            return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        Car ret = carService.getCarById(id);
        if(ret != null){
            return new ResponseEntity<Car>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car ret = carService.saveCar(car);
        if(ret != null){
            return new ResponseEntity<Car>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<Car>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        if(carService.deleteCar(id)){
            return new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id invalid",HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        Car ret = carService.updateCar(id, car);
        if(ret != null){
            return new ResponseEntity<Car>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<Car>(HttpStatus.FORBIDDEN);
        }
    }

}
