package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Entity.Reputation;
import com.example.AvtoShop.Service.ReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReputationController {

    @Autowired
    private ReputationService reputationService;

    @GetMapping("/reputation")
    public List<Reputation> all(){
        return reputationService.getAllFromReputation();
    }

    @GetMapping ("/reputation/{reputationID}")
    public Reputation one(@PathVariable Long reputationID){
        return reputationService.getOneFromReputation(reputationID);
    }

    @PostMapping("/reputation")
    public Reputation createReputation (@RequestBody Reputation reputation){
        return reputationService.createReputation(reputation);
    }

    @PutMapping ("/reputation/{reputationID}")
    public Reputation updateReputation (@PathVariable Long reputationID,
                                @RequestBody Reputation newReputation){
        return reputationService.updateReputation(reputationID, newReputation);
    }

    @DeleteMapping ("/reputation/{reputationID}")
    public void deleteReputation (@PathVariable Long reputationID){
        reputationService.deleteReputation(reputationID);
    }
}
