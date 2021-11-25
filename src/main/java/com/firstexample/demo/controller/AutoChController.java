package com.firstexample.demo.controller;

import com.firstexample.demo.dto.ListOfCarsDTO;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autoch/search")
public class AutoChController {

    private final CarService carservice;

    @Autowired
    public AutoChController(CarService carservice){
        this.carservice=carservice;
    }

    @GetMapping()
    @ResponseBody
    public ListOfCarsDTO search_cars(@RequestParam(required = false) String brand, @RequestParam(required = false) String model, @RequestParam(required = false) String year) {
        Integer year_converted;
        if(year==null)year_converted=null;
        else year_converted=Integer.parseInt(year);
        Collection<Car>cars= carservice.get_on_multiple_params(brand,model,year_converted);
        ListOfCarsDTO loc=new ListOfCarsDTO();
        List<Car> newCarList = new ArrayList<>(cars);
        loc.setCars(newCarList);
        return loc;

    }


}
