package com.firstexample.demo.controller;

import com.firstexample.demo.dto.CarDTO;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.service.CarService;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class  CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<Car> createCar(@RequestBody CarDTO car){
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCarsByParameters(
            @And({
                    @Spec(path = "engine_number", params = "engine_number", spec = Equal.class),
                    @Spec(path = "chassisSerialNumber", params = "chassisSerialNumber", spec = Equal.class),
                    @Spec(path = "brand", params = "brand", spec = In.class),
                    @Spec(path = "model", params = "model", spec = In.class),
                    @Spec(path = "productionDate", params = "productionDateAfter", spec = GreaterThanOrEqual.class),
                    @Spec(path = "productionDate", params = "productionDateBefore", spec = LessThanOrEqual.class),
                    @Spec(path = "firstRegistration", params = "firstRegistrationBefore", spec = LessThanOrEqual.class),
                    @Spec(path = "firstRegistration", params = "firstRegistrationAfter", spec = GreaterThanOrEqual.class),
                    @Spec(path = "mileage", params = "mileageGreater", spec = GreaterThanOrEqual.class),
                    @Spec(path = "mileage", params = "mileageLess", spec = LessThanOrEqual.class),
            }) Specification<Car> spec) {
        List<Car> cars = carService.getCarsByParameters(spec);
        if(cars != null){
            return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
