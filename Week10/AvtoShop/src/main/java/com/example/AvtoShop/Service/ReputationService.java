package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Reputation;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ReputationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReputationService {

    private final ReputationRepository reputationRepository;

    @Autowired
    public ReputationService(ReputationRepository reputationRepository) {
        this.reputationRepository = reputationRepository;
    }

    public List<Reputation> getAllFromReputation(){
        return reputationRepository.findAll();
    }

    public Reputation getOneFromReputation(Long reputationID){
        return reputationRepository.findById(reputationID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find reputation with ID ", reputationID));
    }

    public Reputation createReputation (Reputation reputation){
        return reputationRepository.save(reputation);
    }

    public Reputation updateReputation (Long reputationID, Reputation newReputation){
        return reputationRepository.findById(reputationID)
                .map(reputation -> {
                    reputation.setReputation(newReputation.getReputation());
                    return reputationRepository.save(reputation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find reputation with ID ", reputationID));
    }

    public void deleteReputation (Long reputationID){
        reputationRepository.deleteById(reputationID);
    }
}
