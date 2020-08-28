package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Shipping;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ShippingRepository;
import com.example.AvtoShop.Service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping ("/shipping")
    public List<Shipping> all(){
        return shippingService.getAllFromShipping();
    }

    @GetMapping ("/shipping/{shippingID}")
    public Shipping one(@PathVariable Long shippingID){
        return shippingService.getOneFromShipping(shippingID);
    }

    @PostMapping ("/shipping")
    public Shipping createShipping (@RequestBody Shipping shipping){
        return shippingService.createShipping(shipping);
    }

    @PutMapping ("/shipping/{shippingID}")
    public Shipping updateShipping (@PathVariable Long shippingID,
                                    @RequestBody Shipping newShipping) {
        return shippingService.updateShipping(shippingID, newShipping);
    }

    @DeleteMapping ("/shipping/{shippingID}")
    public void deleteShipping (@PathVariable Long shippingID){
        shippingService.deleteShipping(shippingID);
    }

}
