package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Car;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController (CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping ("/cars")
    public List<Car> all(){
        return carRepository.findAll();
    }

    @GetMapping ("/cars/{carID}")
    public Car one (@PathVariable Long carID){
        return carRepository.findById(carID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find car ", carID) );
    }

    @PostMapping ("/cars")
    public Car createCar (@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping ("/cars/{carID}")
    public Car updateCar (@RequestBody Car newCar, @PathVariable Long carID){
        return carRepository.findById(carID)
                .map(car -> {
                    car.setCarName(newCar.getCarName());
                    car.setColor(newCar.getColor());
                    car.setEngineDisplacement((newCar.getEngineDisplacement()));
                    car.setPriceID(newCar.getPriceID());
                    car.setCarType(newCar.getCarType());
                    return carRepository.save(car);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find car ", carID) );
    }

    @DeleteMapping ("/cars/{carID}")
    public void deleteCar (@PathVariable Long carID){
        carRepository.deleteById(carID);
    }

}
