package com.firstexample.demo.dto;

import com.firstexample.demo.model.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

    private String engineNumber;
    private Long engineTypeId;
    private String chassisSerialNumber;
    private Long chassisId;
    private String brand;
    private String model;
    private Date productionDate;
    private Date firstRegistration;
    private Double mileage;

    public CarDTO(String engineNumber, Long engineTypeId, String chassisSerialNumber, Long chassisId, String brand, String model, Date productionDate, Date firstRegistration, Double mileage) {
        this.engineNumber = engineNumber;
        this.engineTypeId = engineTypeId;
        this.chassisSerialNumber = chassisSerialNumber;
        this.chassisId = chassisId;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }

}
