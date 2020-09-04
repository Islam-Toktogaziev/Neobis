package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Position;
import com.example.AvtoShop.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping ("/position")
    public List<Position> all() {
        return positionService.getAllFromPositions();
    }

    @GetMapping ("/position/{positionID}")
    public Position one (@PathVariable Long positionID){
        return positionService.getOneFromPositions(positionID);
    }

    @PostMapping ("/position")
    public Position createPosition (@RequestBody Position position){
        return positionService.createPosition(position);
    }

    @PutMapping("/position/{positionID}")
    public Position updatePosition (@PathVariable Long positionID,
                                    @RequestBody Position newPosition){
        return positionService.updatePosition(positionID, newPosition);
    }

    @DeleteMapping ("/position/{positionID}")
    public void deletePosition (@PathVariable Long positionID){
        positionService.deletePosition(positionID);
    }

}
