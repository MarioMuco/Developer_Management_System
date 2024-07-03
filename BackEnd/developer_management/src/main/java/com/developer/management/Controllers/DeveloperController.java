package com.developer.management.Controllers;

import com.developer.management.Entities.Developer;
import com.developer.management.Repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping("")
    public ResponseEntity<Collection<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addDeveloper")
    public ResponseEntity<Developer> addNewDeveloper(@RequestBody Developer developer){
        return new ResponseEntity<>(developerRepository.save(developer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloper(@PathVariable Long id){
        Developer developer = developerRepository.findById(id).orElse(null);
        if (developer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Developer> editDeveloper(@PathVariable Long id, @RequestBody Developer developer){
        Optional<Developer> currentDeveloper = developerRepository.findById(id);
        Developer newDeveloper = currentDeveloper.get();
        newDeveloper.setFirst_name(developer.getFirst_name());
        newDeveloper.setLast_name(developer.getLast_name());
        newDeveloper.setExperience(developer.getExperience());
        newDeveloper.setSkills(developer.getSkills());
        newDeveloper.setProfile_photo(developer.getProfile_photo());
        return new ResponseEntity<>(developerRepository.save(newDeveloper), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeveloper(@PathVariable Long id){
        developerRepository.deleteById(id);
    }
}