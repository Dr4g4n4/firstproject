package com.firstexample.demo.controller;


import com.firstexample.demo.Search;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.repository.CarRepository;
import com.firstexample.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

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
    public Collection<Car> getByModel(@RequestParam String model) {

        return carservice.getCarByModel(model);
    }
    @GetMapping("/byBrand")
    @ResponseBody
    public Collection<Car> getByBrand(@RequestParam String brand) {
        return carservice.getCarsByBrand(brand);
    }

    @GetMapping("/byGreaterMileage")
    @ResponseBody
    public Collection<Car> getByMileageGT(@RequestParam Integer mileage) {
        return carservice.findCarByMileageGT(mileage);
    }
    @GetMapping("/byLowerMileage")
    @ResponseBody
    public Collection<Car> getByMileageLT(@RequestParam Integer mileage) {
        return carservice.findCarByMileageLT(mileage);
    }

    @GetMapping("/byMileageRange")
    @ResponseBody
    public Collection<Car> getByMileageLT(@RequestParam Integer frommileage,@RequestParam Integer tomileage) {
        return carservice.findCarByMileageBT(frommileage,tomileage);
    }





}
