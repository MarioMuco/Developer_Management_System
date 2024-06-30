package com.developer.management.Repositories;

import com.developer.management.Entities.Developer;
import com.developer.management.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
