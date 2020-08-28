package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Brand;
import com.example.AvtoShop.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping ("/brand")
    public List<Brand> getAll(){
        return brandService.getAllFromBrand();
    }

    @GetMapping ("/brand/{brandID}")
    public Brand getOne(@PathVariable Long brandID){
        return brandService.getOneFromBrand(brandID);
    }

    @PostMapping("/brand")
    public Brand createBrand (@RequestBody Brand brand ){
        return brandService.createNewBrand(brand);
    }

    @PutMapping("/brand/{brandID}")
    public Brand updateBrand (@RequestBody Brand newBrand, @PathVariable Long brandID){
        return brandService.updateBrand(newBrand,brandID);
    }

    @DeleteMapping ("/brand/{brandID}")
    public void deleteBrand (@PathVariable Long brandID){
        brandService.deleteBrand(brandID);
    }
    }

