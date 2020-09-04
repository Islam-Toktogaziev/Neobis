package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Region;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllFromRegion(){
        return regionRepository.findAll();
    }

    public Region getOneFromRegion(Long regionID){
        return regionRepository.findById(regionID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find region with ID ", regionID));
    }

    public Region createRegion (Region region){
        return regionRepository.save(region);
    }

    public Region updateRegion (Long regionID, Region newRegion){
        return regionRepository.findById(regionID)
                .map(region -> {
                    region.setRegion(newRegion.getRegion());
                    return regionRepository.save(region);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find region with ID ", regionID));
    }

    public void deleteRegion (Long regionID){
        regionRepository.deleteById(regionID);
    }
}
