package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.PriceList;
import com.example.AvtoShop.Service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @GetMapping ("/price")
    public List<PriceList> all(){
        return priceListService.getPriceList();
    }

    @GetMapping ("/price/{priceID}")
    public PriceList one(@PathVariable Long priceID){
        return priceListService.getOneFromPrice(priceID);
    }

    @PostMapping ("/price")
    public PriceList createPrice (@RequestBody PriceList price){
        return priceListService.createPrice(price);
    }

    @PutMapping ("/price/{priceID}")
    public PriceList updatePrice (@PathVariable Long priceID,
                                  @RequestBody PriceList newPrice){
        return priceListService.updatePrice(priceID, newPrice);
    }

    @DeleteMapping ("/price/{priceID}")
    public void deletePrice (@PathVariable Long priceID){
        priceListService.deletePrice(priceID);
    }

}
