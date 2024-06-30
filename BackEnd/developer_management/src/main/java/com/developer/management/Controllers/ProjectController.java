package com.developer.management.Controllers;

import com.developer.management.Entities.Developer;
import com.developer.management.Entities.Project;
import com.developer.management.Repositories.DeveloperRepository;
import com.developer.management.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<Collection<Project>> getAllProjects() {
        return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
    }

}
