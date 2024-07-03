package com.developer.management.Controllers;

import com.developer.management.Entities.Developer;
import com.developer.management.Entities.Project;
import com.developer.management.Repositories.DeveloperRepository;
import com.developer.management.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("")
    public ResponseEntity<Collection<Project>> getAllProjects() {
        return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addProject")
    public ResponseEntity<Project> addNewProject(@RequestBody Project project){
        return new ResponseEntity<>(projectRepository.save(project), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Project> editProject(@PathVariable Long id, @RequestBody Project project){
        Optional<Project> currentProject = projectRepository.findById(id);
        Project newProject = currentProject.get();
        newProject.setAdded_at(project.getAdded_at());
        newProject.setName(project.getName());
        newProject.setTechnology(project.getTechnology());
        return new ResponseEntity<>(projectRepository.save(newProject), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id){
        projectRepository.deleteById(id);
    }

}
