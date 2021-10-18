package com.firstexample.demo.controller;


import com.firstexample.demo.Search;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.repository.CarRepository;
import com.firstexample.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class SearchController {


    private final CarService carservice;

    @Autowired
    public SearchController(CarService carservice){
        this.carservice=carservice;
    }


   // @GetMapping("/greeting")
   // public String greetingForm(Model model) {
    //    model = model.addAttribute("message", "heloo");
     //   return "greeting";
    //}


   // @PostMapping("/greeting")
   // public String showCars(@ModelAttribute Search search, Model model){

       // model.addAttribute("cars", Arrays.asList(new Car()));
       // return "showCars";
  //  }
    @GetMapping("/byModel")
    @ResponseBody
    public  List<Map<String,Object>> getByModel(@RequestParam String model) {

        return sayHello(carservice.getCarByModel(model));
    }
    @GetMapping("/byBrand")
    @ResponseBody
    public Collection<Car> getByBrand(@RequestParam String brand) {
        return carservice.getCarsByBrand(brand);
    }

    @GetMapping("/byGreaterMileage")
    @ResponseBody
    public Collection<Car> getByMileageGT(@RequestParam Integer mileage) {
        return carservice.getCarByMileageGT(mileage);
    }
    @GetMapping("/byLowerMileage")
    @ResponseBody
    public Collection<Car> getByMileageLT(@RequestParam Integer mileage) {
        return carservice.getCarByMileageLT(mileage);
    }

    @GetMapping("/byMileageRange")
    @ResponseBody
    public Collection<Car> getByMileageLT(@RequestParam Integer frommileage,@RequestParam Integer tomileage) {
        return carservice.getCarByMileageBT(frommileage,tomileage);
    }

    @GetMapping("/byGreaterProductionDate")
    @ResponseBody
    public Collection<Car> getByProductionDateGT(@RequestParam Date date){
        return carservice.getCarByProductionDateGT(date);
    }

    @GetMapping("/byLowerProductionDate")
    @ResponseBody
    public Collection<Car> getCarProductionDateLT(@RequestParam Date date){
        return carservice.getCarByProductionDateLT(date);
    }

    @GetMapping("/byProductionDateRange")
    @ResponseBody
    public Collection<Car> getCarByProductionDateBT(@RequestParam Date fromdate,@RequestParam Date todate){
        return carservice.getCarByProductionDateBT(fromdate, todate);
    }

    @GetMapping("/byFuelType")
    @ResponseBody
    public Collection<Car> getCarByFuel(@RequestParam String fuel){

        return carservice.getCarByFuel(fuel);
    }

    @GetMapping("/byMotorVolume")
    @ResponseBody
    public Collection<Car> getCarByMotorVolume(@RequestParam int volume){

        return  carservice.getCarByMotorVolume(volume);
    }

    @GetMapping("/byGreaterMotorPower")
    @ResponseBody
    public Collection<Car> getCarByMotorPowerGT(@RequestParam int mp){

        return carservice.getCarByMotorPowerGT(mp);
    }

    @GetMapping("/byGreaterHorsePower")
    @ResponseBody
    public Collection<Car> getCarByHorsePowerGT(@RequestParam int hp){

        return carservice.getCarByHorsePowerGT(hp);
    }

    @GetMapping("/byLowerMotorPower")
    @ResponseBody
    public Collection<Car> getCarByMotorMotorPowerLT(@RequestParam int mp){

        return  carservice.getCarByMotorPowerLT(mp);
    }

    @GetMapping("/byLowerHorsePower")
    @ResponseBody
    public Collection<Car> getCarByHorsePowerLT(@RequestParam int hp){

        return carservice.getCarByHorsePowerLT(hp);
    }

    @GetMapping("/byMotorPowerRange")
    @ResponseBody
    public Collection<Car> getCarByMotorPowerBT(@RequestParam int frommp,@RequestParam int tomp){
        return carservice.getCarByMotorPowerBT(frommp,tomp);
    }

    @GetMapping("/byHosePowerRange")
    @ResponseBody
    public Collection<Car> getCarByHorsePowerBT(@RequestParam int fromhp,@RequestParam int tohp){
        return carservice.getCarByHorsePowerBT(fromhp,tohp);
    }

    @GetMapping("/byColor")
    @ResponseBody
    public Collection<Car> getCarByColor(@RequestParam String color){

        return carservice.getCarByColor(color);
    }


    private  List<Map<String,Object>> sayHello(Collection<Car> cars)
    {
        //Get data from service layer into entityList.


       // Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result
        List<Map<String,Object>> liste= new ArrayList<Map<String,Object>>();
        for (Car c: cars) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("motor",c.getEngineType().getMotorPower());
            liste.add(map);
        }

        return liste;
      //  return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }





}
