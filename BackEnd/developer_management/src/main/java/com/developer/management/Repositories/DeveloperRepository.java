package com.developer.management.Repositories;

import com.developer.management.Entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
