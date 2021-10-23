package com.firstexample.demo.controller;

import com.firstexample.demo.model.EngineType;
import com.firstexample.demo.service.EngineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine")
public class EngineTypeController {

    @Autowired
    private EngineTypeService engineTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EngineType>> getEngineTypes() {
        List<EngineType> EngineTypes= engineTypeService.getAllEngineTypes();
        if(EngineTypes != null){
            return new ResponseEntity<List<EngineType>>(EngineTypes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EngineType> getEngineType(@PathVariable Long id){
        EngineType ret = engineTypeService.getEngineTypeById(id);
        if(ret != null){
            return new ResponseEntity<EngineType>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping()
    public ResponseEntity<EngineType> createEngineType (@RequestBody EngineType engineType){
        EngineType ret = engineTypeService.saveEngineType(engineType);
        if(ret != null){
            return new ResponseEntity<EngineType>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<EngineType>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(engineTypeService.deleteEngineType(id)){
            return new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id invalid",HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EngineType> update(@PathVariable Long id, @RequestBody EngineType EngineType){
        EngineType ret = engineTypeService.updateEngineType(id, EngineType);
        if(ret != null){
            return new ResponseEntity<EngineType>(ret, HttpStatus.OK);
        }else{
            return new ResponseEntity<EngineType>(HttpStatus.FORBIDDEN);
        }
    }

}
