package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.PriceList;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {

    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListService(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    public List<PriceList> getPriceList(){
        return priceListRepository.findAll();
    }

    public PriceList getOneFromPrice(Long priceID){
        return priceListRepository.findById(priceID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find price with ID ", priceID));
    }

    public PriceList createPrice (PriceList price){
        return priceListRepository.save(price);
    }

    public PriceList updatePrice (Long priceID, PriceList newPrice){
        return priceListRepository.findById(priceID)
                .map(priceList -> {
                    priceList.setPrice(newPrice.getPrice());
                    return priceListRepository.save(priceList);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find price with ID ", priceID));
    }

    public void deletePrice (Long priceID){
        priceListRepository.deleteById(priceID);
    }
}
