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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public  List<Map<String,Object>> getByModel(@RequestParam(required = false) String model) {
        if(model==null){
            return formResponseError("You need to add Queryparam model");
        }
        return formResponse(carservice.getCarByModel(model));
    }
    @GetMapping("/byBrand")
    @ResponseBody
    public List<Map<String,Object>> getByBrand(@RequestParam(required = false) String brand) {
        if(brand==null){
            return formResponseError("You need to add Queryparam brand");
        }
        return formResponse(carservice.getCarsByBrand(brand));
    }

    @GetMapping("/byGreaterMileage")
    @ResponseBody
    public List<Map<String,Object>> getByMileageGT(@RequestParam Integer mileage) {
        return formResponse(carservice.getCarByMileageGT(mileage));
    }
    @GetMapping("/byLowerMileage")
    @ResponseBody
    public List<Map<String,Object>> getByMileageLT(@RequestParam Integer mileage) {
        return formResponse(carservice.getCarByMileageLT(mileage));
    }

    @GetMapping("/byMileageRange")
    @ResponseBody
    public List<Map<String,Object>> getByMileageLT(@RequestParam Integer frommileage,@RequestParam Integer tomileage) {
        return formResponse(carservice.getCarByMileageBT(frommileage,tomileage));
    }

    @GetMapping("/byGreaterProductionDate")
    @ResponseBody
    public List<Map<String,Object>> getByProductionDateGT(@RequestParam String date)  {
        try {
            Date date_c=new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return formResponse(carservice.getCarByProductionDateGT(date_c));
        }
        catch (ParseException pe){
            return formResponseError("Invalid date type");
        }

    }

    @GetMapping("/byLowerProductionDate")
    @ResponseBody
    public List<Map<String,Object>> getCarProductionDateLT(@RequestParam Date date){
        return formResponse(carservice.getCarByProductionDateLT(date));
    }

    @GetMapping("/byProductionDateRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByProductionDateBT(@RequestParam Date fromdate,@RequestParam Date todate){
        return formResponse(carservice.getCarByProductionDateBT(fromdate, todate));
    }

    @GetMapping("/byFuelType")
    @ResponseBody
    public List<Map<String,Object>> getCarByFuel(@RequestParam String fuel){

        return formResponse(carservice.getCarByFuel(fuel));
    }

    @GetMapping("/byMotorVolume")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorVolume(@RequestParam(required = false) String volume){
        if(volume==null){
            return formResponseError("You need to add Queryparam volume");
        }
        try {
            int volume_c=Integer.parseInt(volume);
            return  formResponse(carservice.getCarByMotorVolume(volume_c));
        }
        catch (Exception e){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byGreaterMotorPower")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorPowerGT(@RequestParam int mp){

        return formResponse(carservice.getCarByMotorPowerGT(mp));
    }

    @GetMapping("/byGreaterHorsePower")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerGT(@RequestParam int hp){

        return formResponse(carservice.getCarByHorsePowerGT(hp));
    }

    @GetMapping("/byLowerMotorPower")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorMotorPowerLT(@RequestParam int mp){

        return formResponse(carservice.getCarByMotorPowerLT(mp));
    }

    @GetMapping("/byLowerHorsePower")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerLT(@RequestParam int hp){

        return formResponse(carservice.getCarByHorsePowerLT(hp));
    }

    @GetMapping("/byMotorPowerRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorPowerBT(@RequestParam int frommp,@RequestParam int tomp){
        return formResponse(carservice.getCarByMotorPowerBT(frommp,tomp));
    }

    @GetMapping("/byHosePowerRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerBT(@RequestParam int fromhp,@RequestParam int tohp){
        return formResponse(carservice.getCarByHorsePowerBT(fromhp,tohp));
    }

    @GetMapping("/byColor")
    @ResponseBody
    public List<Map<String,Object>> getCarByColor(@RequestParam String color){

        return formResponse(carservice.getCarByColor(color));
    }


    private  List<Map<String,Object>> formResponse(Collection<Car> cars)
    {
        //Get data from service layer into entityList.


       // Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result
        List<Map<String,Object>> liste= new ArrayList<Map<String,Object>>();
        for (Car c: cars) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("brand",c.getBrand());
            map.put("model",c.getModel());
            map.put("first_registration",c.getFirstRegistration());
            map.put("mileage",c.getMileage());
            map.put("production_date",c.getProductionDate());
            map.put("horse_power",c.getEngineType().getHPower());
            map.put("motor_power",c.getEngineType().getMotorPower());
            map.put("motor_cylinderType",c.getEngineType().getCylinderType());
            map.put("primary_Fuel",c.getEngineType().getPrimaryFuel());
            map.put("secondary_Fuel",c.getEngineType().getSecondaryFuel());
            map.put("color",c.getChassis().getColor());
            map.put("height",c.getChassis().getHeight());
            map.put("width",c.getChassis().getWidth());
            map.put("length",c.getChassis().getLength());
            map.put("volume",c.getChassis().getVolume());

            liste.add(map);
        }

        return liste;
      //  return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    private  List<Map<String,Object>> formResponseError(String error){
        List<Map<String,Object>> liste= new ArrayList<Map<String,Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error",error);
            liste.add(map);


        return liste;
    }



}
