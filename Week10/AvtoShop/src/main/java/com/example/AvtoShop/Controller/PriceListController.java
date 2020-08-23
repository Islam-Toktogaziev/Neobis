package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.PriceList;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceListController {

    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListController(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    @GetMapping ("/price")
    public List<PriceList> all(){
        return priceListRepository.findAll();
    }

    @GetMapping ("/price/{priceID}")
    public PriceList one(@PathVariable Long priceID){
        return priceListRepository.findById(priceID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find priceID ", priceID));
    }

    @PostMapping ("/price")
    public PriceList createPrice (@RequestBody PriceList price){
        return priceListRepository.save(price);
    }

    @PutMapping ("/price/{priceID}")
    public PriceList updatePrice (@PathVariable Long priceID,
                                  @RequestBody PriceList newPrice){
        return priceListRepository.findById(priceID)
                .map(priceList -> {
                    priceList.setPrice(newPrice.getPrice());
                    return priceListRepository.save(priceList);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find priceID ", priceID));
    }

    @DeleteMapping ("/price/{priceID}")
    public void deletePrice (@PathVariable Long priceID){
        priceListRepository.deleteById(priceID);
    }

}
