package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.CarType;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CarTypeRepository;
import com.example.AvtoShop.Service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;

    @GetMapping("/car-type")
    public List<CarType> all(){
        return carTypeService.getAllFromCarType();
    }

    @GetMapping ("/car-type/{carTypeID}")
    public CarType one (@PathVariable Long carTypeID){
        return carTypeService.getOneFromCarType(carTypeID);
    }

    @PostMapping("/car-type")
    public CarType createCar (@RequestBody CarType carType){
        return carTypeService.createCarType(carType);
    }

    @PutMapping("/car-type/{carTypeID}")
    public CarType updateCarType (@RequestBody CarType newCarType, @PathVariable Long carTypeID){
        return carTypeService.updateCarType(newCarType,carTypeID);
    }

    @DeleteMapping ("/car-type/{carTypeID}")
    public void deleteCar (@PathVariable Long carTypeID){
        carTypeService.deleteCarType(carTypeID);
    }

}
