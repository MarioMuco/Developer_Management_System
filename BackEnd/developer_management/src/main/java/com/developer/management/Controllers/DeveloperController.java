package com.developer.management.Controllers;

import com.developer.management.Entities.Developer;
import com.developer.management.Repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping
    public ResponseEntity<Collection<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerRepository.findAll(), HttpStatus.OK);
    }

}
