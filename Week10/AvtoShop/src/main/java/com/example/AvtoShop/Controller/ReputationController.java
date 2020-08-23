package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Reputation;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.ReputationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReputationController {

    private final ReputationRepository reputationRepository;

    @Autowired
    public ReputationController(ReputationRepository reputationRepository) {
        this.reputationRepository = reputationRepository;
    }

    @GetMapping("/reputation")
    public List<Reputation> all(){
        return reputationRepository.findAll();
    }

    @GetMapping ("/reputation/{reputationID}")
    public Reputation one(@PathVariable Long reputationID){
        return reputationRepository.findById(reputationID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find regionID ", reputationID));
    }

    @PostMapping("/reputation")
    public Reputation createReputation (@RequestBody Reputation reputation){
        return reputationRepository.save(reputation);
    }

    @PutMapping ("/reputation/{reputationID}")
    public Reputation updateReputation (@PathVariable Long reputationID,
                                @RequestBody Reputation newReputation){
        return reputationRepository.findById(reputationID)
                .map(reputation -> {
                    reputation.setReputation(newReputation.getReputation());
                    return reputationRepository.save(reputation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Could not find regionID ", reputationID));
    }

    @DeleteMapping ("/reputation/{reputationID}")
    public void deleteReputation (@PathVariable Long reputationID){
        reputationRepository.deleteById(reputationID);
    }
}
