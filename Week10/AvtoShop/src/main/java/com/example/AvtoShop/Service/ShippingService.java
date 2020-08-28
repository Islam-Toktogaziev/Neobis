package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Shipping;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<Shipping> getAllFromShipping(){
        return shippingRepository.findAll();
    }

    public Shipping getOneFromShipping(Long shippingID){
        return shippingRepository.findById(shippingID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find shipping with ID ", shippingID));
    }

    public Shipping createShipping (Shipping shipping){
        return shippingRepository.save(shipping);
    }

    public Shipping updateShipping (Long shippingID, Shipping newShipping) {
        return shippingRepository.findById(shippingID)
                .map(shipping -> {
                    shipping.setRegion(newShipping.getRegion());
                    shipping.setShippingCost(newShipping.getShippingCost());
                    shipping.setShippingType(newShipping.getShippingType());
                    return shippingRepository.save(shipping);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find shipping with ID ", shippingID));
    }

    public void deleteShipping (Long shippingID){
        shippingRepository.deleteById(shippingID);
    }
}
