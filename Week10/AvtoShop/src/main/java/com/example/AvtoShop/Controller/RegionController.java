package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Region;
import com.example.AvtoShop.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping ("/region")
    public List<Region> all(){
        return regionService.getAllFromRegion();
    }

    @GetMapping ("/region/{regionID}")
    public Region one(@PathVariable Long regionID){
        return regionService.getOneFromRegion(regionID);
    }

    @PostMapping ("/region")
    public Region createRegion (@RequestBody Region region){
        return regionService.createRegion(region);
    }

    @PutMapping ("/region/{regionID}")
    public Region updateRegion (@PathVariable Long regionID,
                                @RequestBody Region newRegion){
        return regionService.updateRegion(regionID, newRegion);
    }

    @DeleteMapping ("/region/{regionID}")
    public void deleteRegion (@PathVariable Long regionID){
        regionService.deleteRegion(regionID);
    }
}
