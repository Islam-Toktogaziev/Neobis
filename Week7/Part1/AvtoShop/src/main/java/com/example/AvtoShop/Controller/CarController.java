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

    @GetMapping ("/cars/{id}")
    public Car one (@PathVariable Long id){
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    @PostMapping ("/cars")
    public Car createCar (@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping ("/cars/{id}")
    public Car updateCar (@RequestBody Car newCar, @PathVariable Long id){
        return carRepository.findById(id)
                .map(car -> {
                    car.setCarName(newCar.getCarName());
                    car.setColor(newCar.getColor());
                    car.setEngineDisplacement((newCar.getEngineDisplacement()));
                    car.setPriceID(newCar.getPriceID());
                    car.setCarType(newCar.getCarType());
                    return carRepository.save(car);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    @DeleteMapping ("/cars/{id}")
    public void deleteCar (@PathVariable Long id){
        carRepository.deleteById(id);
    }

}
