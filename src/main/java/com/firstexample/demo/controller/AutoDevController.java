package com.firstexample.demo.controller;


import com.firstexample.demo.dto.ListOfCarsDTO;
import com.firstexample.demo.model.Car;
import com.firstexample.demo.service.CarService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/autodev")
public class AutoDevController {

    private final CarService carservice;

    @Autowired
    public AutoDevController(CarService carservice){
        this.carservice=carservice;
    }
    @GetMapping(value = "/proba")
    @ResponseBody
    public ListOfCarsDTO search_cars(@RequestParam(required = false) String brand, @RequestParam(required = false) String model, @RequestParam(required = false) String year) {
        Integer year_converted;
        ListOfCarsDTO loc=new ListOfCarsDTO();
        if(year==null)year_converted=null;
        else year_converted=Integer.parseInt(year);
        try {

            String q="apikey=KhFeArhWkaNrih";
            if(brand!=null)q+="&make="+brand;
            if(model!=null)q+="&model="+model;
            if(year!=null)q+="&year_min="+year;
            String url="https://auto.dev/api/listings?"+ URLEncoder.encode(q, StandardCharsets.UTF_8);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);


            HttpResponse response = httpClient.execute(request);
            //   System.out.println(response.getStatusLine().getStatusCode());

            String json = EntityUtils.toString(response.getEntity());
            //       System.out.println(json);
            JSONObject temp1 = new JSONObject(json);
            JSONArray jarray=(JSONArray)temp1.get("records");
            List<Car> cars=new ArrayList<>();
            for(int i=0;i<jarray.length();i++){
                cars.add(this.carservice.create_Car_From_Json_Auto_Dev(jarray.getJSONObject(i)));
            }
            loc.setCars(cars);
        }
        catch (Exception e){}


        return loc;

    }

}
