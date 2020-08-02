package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.CarType;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTypeController {

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeController (CarTypeRepository carTypeRepository){
        this.carTypeRepository = carTypeRepository;
    }

    @GetMapping("/carType")
    public List<CarType> all(){
        return carTypeRepository.findAll();
    }

    @GetMapping ("/carType/{carTypeID}")
    public CarType one (@PathVariable Long carTypeID){
        return carTypeRepository.findById(carTypeID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find type of car ", carTypeID) );
    }

    @PostMapping("/carType")
    public CarType createCar (@RequestBody CarType carType){
        return carTypeRepository.save(carType);
    }

    @PutMapping("/carType/{carTypeID}")
    public CarType updateCarType (@RequestBody CarType newCarType, @PathVariable Long carTypeID){
        return carTypeRepository.findById(carTypeID)
                .map(carType -> {
                    carType.setCarType(newCarType.getCarType());
                    return carTypeRepository.save(carType);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find type of car ", carTypeID) );
    }

    @DeleteMapping ("/carType/{carTypeID}")
    public void deleteCar (@PathVariable Long carTypeID){
        carTypeRepository.deleteById(carTypeID);
    }

}
