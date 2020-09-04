package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Brand;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List <Brand> getAllFromBrand (){
        return brandRepository.findAll();
    }

    public Brand getOneFromBrand (Long brandID){
        return brandRepository.findById(brandID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find brand with ID ",brandID));
    }

    public Brand createNewBrand (Brand brand){
        return brandRepository.save(brand);
    }

    public Brand updateBrand (Brand newBrand, Long brandID){
        return brandRepository.findById(brandID)
                .map(brand -> {
                    brand.setBrand(newBrand.getBrand());
                    return brandRepository.save(brand);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find brand with ID ", brandID) );
    }

    public void deleteBrand (Long brandID){
        brandRepository.deleteById(brandID);
    }


}
