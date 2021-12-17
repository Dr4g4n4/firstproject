package com.firstexample.demo.controller;

import com.firstexample.demo.dto.ListOfCarsDTO;
import com.firstexample.demo.model.Car;

import com.firstexample.demo.service.CarService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//import org.apache.http.entity.StringEntity;
@RestController
@RequestMapping()
public class SwaggerController {
    private final CarService carservice;

    @Autowired
    public SwaggerController(CarService carservice){
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
            JSONObject jsonobj=new JSONObject();
            JSONObject query=new JSONObject();
            if(year_converted!=null) {
                query.put("firstRegistrationYearFrom", year_converted);
                query.put("firstRegistrationYearTo", year_converted);
            }
            JSONObject makeModel=new JSONObject();
            JSONArray listajsona=new JSONArray();
            listajsona.put(makeModel);
            if(brand!=null)
            makeModel.put("makeKey",brand);
            if(model!=null)
            makeModel.put("modelKey",model);
            //   List<JSONObject> lista=new ArrayList<>();
            //lista.add(makeModel);
            query.put("makeModelType",listajsona);
            jsonobj.put("query",query);
            String payload ="{\"query\":{\"firstRegistrationYearFrom\":"+year_converted+",\"firstRegistrationYearTo\":"+year_converted+", \"makeModelType\": [" +
                    "      {"+
                    "        \"makeKey\": \""+brand+"\"," +
                    "        \"modelKey\": \""+model+"\"}]}}";
            System.out.println(payload);
            System.out.println(jsonobj);
            StringEntity entity = new StringEntity(jsonobj.toString(),
                    ContentType.APPLICATION_JSON);

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost("https://inventory-search-service.preprod.carforyou.ch:443/api/listings/search");
            request.setEntity(entity);

            HttpResponse response = httpClient.execute(request);
         //   System.out.println(response.getStatusLine().getStatusCode());

           String json = EntityUtils.toString(response.getEntity());
     //       System.out.println(json);
            JSONObject temp1 = new JSONObject(json);
            JSONArray jarray=(JSONArray)temp1.get("content");
            List<Car>cars=new ArrayList<>();
           for(int i=0;i<jarray.length();i++){
             cars.add(this.carservice.create_Car_From_Json_Car_for_you(jarray.getJSONObject(i)));
           }
           loc.setCars(cars);
        }
        catch (Exception e){}


        return loc;

    }


}
