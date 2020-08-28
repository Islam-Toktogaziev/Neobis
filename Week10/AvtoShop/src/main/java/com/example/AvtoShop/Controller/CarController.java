package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Car;
import com.example.AvtoShop.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping ("/cars")
    public List<Car> all(){
        return carService.getAllFromCars();
    }

    @GetMapping ("/cars/{carID}")
    public Car one (@PathVariable Long carID){
        return carService.getOneFromCars(carID);
    }

    @PostMapping ("/cars")
    public Car createCar (@RequestBody Car car){
        return carService.createCar(car);
    }

    @PutMapping ("/cars/{carID}")
    public Car updateCar (@RequestBody Car newCar, @PathVariable Long carID){
        return carService.updateCar(newCar,carID);
    }

    @DeleteMapping ("/cars/{carID}")
    public void deleteCar (@PathVariable Long carID){
        carService.deleteCar(carID);
    }

}
