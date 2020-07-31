package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Shipping;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingController {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingController(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @GetMapping ("/shipping")
    public List<Shipping> all(){
        return shippingRepository.findAll();
    }

    @GetMapping ("/shipping/{shippingID}")
    public Shipping one(@PathVariable Long shippingID){
        return shippingRepository.findById(shippingID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find shippingID", shippingID));
    }

    @PostMapping ("/shipping")
    public Shipping createShipping (@RequestBody Shipping shipping){
        return shippingRepository.save(shipping);
    }

    @PutMapping ("/shipping/{shippingID}")
    public Shipping updateShipping (@PathVariable Long shippingID,
                                    @RequestBody Shipping newShipping) {
        return shippingRepository.findById(shippingID)
                .map(shipping -> {
                    shipping.setRegion(newShipping.getRegion());
                    shipping.setShippingCost(newShipping.getShippingCost());
                    shipping.setShippingType(newShipping.getShippingType());
                    return shippingRepository.save(shipping);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find shippingID", shippingID));
    }

    @DeleteMapping ("/shipping/{shippingID}")
    public void deleteShipping (@PathVariable Long shippingID){
        shippingRepository.deleteById(shippingID);
    }

}
