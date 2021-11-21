package com.firstexample.demo.controller;

import com.firstexample.demo.model.Car;
import com.firstexample.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/mobilede/search")
public class MobileDeController {

    private final CarService carservice;

    @Autowired
    public MobileDeController(CarService carservice){
        this.carservice=carservice;
    }

    @GetMapping()
    @ResponseBody
    public List<Car> search_cars(@RequestParam(required = false) String brand, @RequestParam(required = false) String model, @RequestParam(required = false) String year) {
        Integer year_converted;
        if(year==null)year_converted=null;
        else year_converted=Integer.parseInt(year);
        Collection<Car> cars= carservice.get_on_multiple_params(brand,model,year_converted);
        return new ArrayList(cars);

    }
}
