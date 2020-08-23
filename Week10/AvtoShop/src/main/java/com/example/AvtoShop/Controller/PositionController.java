package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Position;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping ("/position")
    public List<Position> all() {
        return positionRepository.findAll();
    }

    @GetMapping ("/position/{positionID}")
    public Position one (@PathVariable Long positionID){
        return positionRepository.findById(positionID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find position ", positionID));
    }

    @PostMapping ("/position")
    public Position createPosition (@RequestBody Position position){
        return positionRepository.save(position);
    }

    @PutMapping("/position/{positionID}")
    public Position updatePosition (@PathVariable Long positionID,
                                    @RequestBody Position newPosition){
        return positionRepository.findById(positionID)
                .map(position -> {
                    position.setPosition(newPosition.getPosition());
                    return positionRepository.save(position);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find position ", positionID));
    }

    @DeleteMapping ("/position/{positionID}")
    public void deletePosition (@PathVariable Long positionID){
        positionRepository.deleteById(positionID);
    }

}
