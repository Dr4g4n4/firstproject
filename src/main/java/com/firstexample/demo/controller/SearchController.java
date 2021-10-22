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
    public List<Map<String,Object>> getByMileageGT(@RequestParam(required = false) String mileage) {
        if(mileage==null){
            return formResponseError("You need to add Queryparam mileage");
        }
        try {
            return formResponse(carservice.getCarByMileageGT(Integer.parseInt(mileage)));
        }catch (Exception e){
            return formResponseError("Please use integer values");
        }
    }
    @GetMapping("/byLowerMileage")
    @ResponseBody
    public List<Map<String,Object>> getByMileageLT(@RequestParam(required = false) String mileage) {
        if(mileage==null){
            return formResponseError("You need to add Queryparam mileage");
        }
        try {
            return formResponse(carservice.getCarByMileageLT(Integer.parseInt(mileage)));
        }catch (Exception e){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byMileageRange")
    @ResponseBody
    public List<Map<String,Object>> getByMileageLT(@RequestParam(required = false) String frommileage,@RequestParam(required = false) String tomileage) {
        if(frommileage==null || tomileage==null){
            return formResponseError("You need to add Queryparams frommileage and tomileage");
        }
        try {
            return formResponse(carservice.getCarByMotorPowerBT(Integer.parseInt(frommileage),Integer.parseInt(tomileage)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byGreaterProductionDate")
    @ResponseBody
    public List<Map<String,Object>> getByProductionDateGT(@RequestParam(required = false) String date)  {
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
    public List<Map<String,Object>> getCarProductionDateLT(@RequestParam(required = false) String date){
        if(date==null){
            return formResponseError("You need to add Queryparam date");
        }
        try {
            Date date_c=new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return formResponse(carservice.getCarByProductionDateGT(date_c));
        }
        catch (ParseException pe){
            return formResponseError("Invalid date type");
        }
    }

    @GetMapping("/byProductionDateRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByProductionDateBT(@RequestParam(required = false) String fromdate,@RequestParam(required = false) String todate){
        if(fromdate==null || todate==null ){
            return formResponseError("You need to add Queryparams fromdate and todate");
        }
        try {
            Date date_s=new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
            Date date_e=new SimpleDateFormat("dd/MM/yyyy").parse(todate);
            return formResponse(carservice.getCarByProductionDateBT(date_s,date_e));
        }
        catch (ParseException pe){
            return formResponseError("Invalid date type (dd/MM/yyyy");
        }
    }

    @GetMapping("/byFuelType")
    @ResponseBody
    public List<Map<String,Object>> getCarByFuel(@RequestParam(required = false) String fuel){
        if(fuel==null){
            return formResponseError("You need to add Queryparam volume");
        }
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
    public List<Map<String,Object>> getCarByMotorPowerGT(@RequestParam(required = false) String mp){
        if(mp==null){
            return formResponseError("You need to add Queryparam mp");
        }
        try {
            return formResponse(carservice.getCarByMotorPowerGT(Integer.parseInt(mp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }
    }

    @GetMapping("/byGreaterHorsePower")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerGT(@RequestParam(required = false) String hp){
        if(hp==null){
            return formResponseError("You need to add Queryparam hp");
        }
        try {
            return formResponse(carservice.getCarByHorsePowerGT(Integer.parseInt(hp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byLowerMotorPower")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorMotorPowerLT(@RequestParam(required = false) String mp){
        if(mp==null){
            return formResponseError("You need to add Queryparam mp");
        }
        try {
            return formResponse(carservice.getCarByMotorPowerLT(Integer.parseInt(mp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }


    }

    @GetMapping("/byLowerHorsePower")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerLT(@RequestParam(required = false) String hp){
        if(hp==null){
            return formResponseError("You need to add Queryparam hp");
        }
        try {
            return formResponse(carservice.getCarByHorsePowerLT(Integer.parseInt(hp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }


    }

    @GetMapping("/byMotorPowerRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByMotorPowerBT(@RequestParam(required = false) String frommp,@RequestParam String tomp){
        if(frommp==null || tomp==null){
            return formResponseError("You need to add Queryparams frommp and tomp");
        }
        try {
            return formResponse(carservice.getCarByMotorPowerBT(Integer.parseInt(frommp),Integer.parseInt(tomp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byHosePowerRange")
    @ResponseBody
    public List<Map<String,Object>> getCarByHorsePowerBT(@RequestParam(required = false) String fromhp,@RequestParam(required = false) String tohp){
        if(fromhp==null || tohp==null){
            return formResponseError("You need to add Queryparams fromhp and tohp");
        }
        try {
            return formResponse(carservice.getCarByHorsePowerBT(Integer.parseInt(fromhp),Integer.parseInt(tohp)));
        }
        catch (Exception pe){
            return formResponseError("Please use integer values");
        }

    }

    @GetMapping("/byColor")
    @ResponseBody
    public List<Map<String,Object>> getCarByColor(@RequestParam(required = false) String color){
        if(color==null){
            return formResponseError("You need to add Queryparam color");
        }
        try {

            return  formResponse(carservice.getCarByColor(color));
        }
        catch (Exception e){
            return formResponseError("Please use String values");
        }

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
