package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.CarType;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getAllFromCarType (){
        return carTypeRepository.findAll();
    }

    public CarType getOneFromCarType(Long carTypeID){
        return carTypeRepository.findById(carTypeID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find type of car with ID ", carTypeID) );
    }

    public CarType createCarType (CarType carType){
        return carTypeRepository.save(carType);
    }

    public CarType updateCarType(CarType newCarType, Long carTypeID){
        return carTypeRepository.findById(carTypeID)
                .map(carType -> {
                    carType.setCarType(newCarType.getCarType());
                    return carTypeRepository.save(carType);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find type of car with ID ", carTypeID) );
    }

    public void deleteCarType (Long carTypeID){
        carTypeRepository.deleteById(carTypeID);
    }
}
