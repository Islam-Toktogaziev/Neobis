package com.flyway.demo.Controller;


import com.flyway.demo.Exceptions.ResourceNotFoundException;
import com.flyway.demo.Entity.People;
import com.flyway.demo.Repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeopleController {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleController (PeopleRepository peopleRepository){
        this.peopleRepository= peopleRepository;
    }

    @GetMapping ("/people")
    public Iterable<People> all(){
        return peopleRepository.findAll();
    }

    @GetMapping ("/people/{id}")
    public People one (@PathVariable Long id){
        return peopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping("/people")
    public People createPeople (@RequestBody People people){
        return peopleRepository.save(people);
    }

    @PutMapping("/cars/{id}")
    public People updatePeople (@RequestBody People newPeople, @PathVariable Long id){
        return peopleRepository.findById(id)
                .map(people -> {
                    people.setFirstName(newPeople.getFirstName());
                    people.setLastName(newPeople.getLastName());
                    people.setAge(newPeople.getAge());
                    return peopleRepository.save(people);
                }).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @DeleteMapping("/people/{id}")
    public void deletePeople(@PathVariable Long id){
        peopleRepository.deleteById(id);
    }
}
