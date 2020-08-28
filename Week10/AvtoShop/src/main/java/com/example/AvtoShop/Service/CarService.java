package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Car;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

     public List<Car> getAllFromCars (){
        return carRepository.findAll();
    }

    public Car getOneFromCars (Long carID){
        return carRepository.findById(carID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find car with ID ", carID) );
    }

    public Car createCar (Car car){
        return carRepository.save(car);
    }

    public Car updateCar (Car newCar,Long carID){
        return carRepository.findById(carID)
                .map(car -> {
                    car.setCarName(newCar.getCarName());
                    car.setColor(newCar.getColor());
                    car.setEngineDisplacement((newCar.getEngineDisplacement()));
                    car.setPriceID(newCar.getPriceID());
                    car.setCarType(newCar.getCarType());
                    return carRepository.save(car);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find car with ID ", carID) );
    }

    public void deleteCar (Long carID){
        carRepository.deleteById(carID);
    }
}
