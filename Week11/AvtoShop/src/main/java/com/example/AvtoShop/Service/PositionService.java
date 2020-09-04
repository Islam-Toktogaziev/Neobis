package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Position;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllFromPositions() {
        return positionRepository.findAll();
    }

    public Position getOneFromPositions (Long positionID){
        return positionRepository.findById(positionID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find position with ID ", positionID));
    }

    public Position createPosition (Position position){
        return positionRepository.save(position);
    }

    public Position updatePosition (Long positionID, Position newPosition){
        return positionRepository.findById(positionID)
                .map(position -> {
                    position.setPosition(newPosition.getPosition());
                    return positionRepository.save(position);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find position with ID ", positionID));
    }

    public void deletePosition (Long positionID){
        positionRepository.deleteById(positionID);
    }

}
