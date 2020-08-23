package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Region;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping ("/region")
    public List<Region> all(){
        return regionRepository.findAll();
    }

    @GetMapping ("/region/{regionID}")
    public Region one(@PathVariable Long regionID){
        return regionRepository.findById(regionID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find regionID ", regionID));
    }

    @PostMapping ("/region")
    public Region createRegion (@RequestBody Region region){
        return regionRepository.save(region);
    }

    @PutMapping ("/region/{regionID}")
    public Region updateRegion (@PathVariable Long regionID,
                                @RequestBody Region newRegion){
        return regionRepository.findById(regionID)
                .map(region -> {
                    region.setRegion(newRegion.getRegion());
                    return regionRepository.save(region);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find regionID ", regionID));
    }

    @DeleteMapping ("/region/{regionID}")
    public void deleteRegion (@PathVariable Long regionID){
        regionRepository.deleteById(regionID);
    }
}
