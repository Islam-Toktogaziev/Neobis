package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Brand;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping ("/brand")
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping ("/brand/{brandID}")
    public Brand getOne(@PathVariable Long brandID){
        return brandRepository.findById(brandID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find brandID ",brandID));
    }

    @PostMapping("/brand")
    public Brand createBrand (@RequestBody Brand brand ){
        return brandRepository.save(brand);
    }

    @PutMapping("/brand/{brandID}")
    public Brand updateBrand (@RequestBody Brand newBrand, @PathVariable Long brandID){
        return brandRepository.findById(brandID)
                .map(brand -> {
                    brand.setBrand(newBrand.getBrand());
                    return brandRepository.save(brand);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find brandID ", brandID) );
    }

    @DeleteMapping ("/brand/{brandID}")
    public void deleteBrand (@PathVariable Long brandID){
        brandRepository.deleteById(brandID);
    }
    }

