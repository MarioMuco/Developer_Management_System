package com.developer.management.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String technology;
    private String added_at;

    public Project() {}

    public Project(String name, String technology, String added_at) {
        this.name = name;
        this.technology = technology;
        this.added_at = added_at;
    }

     /*
    @ManyToMany(mappedBy = "projects")
    private Set<Developer> developers = new HashSet<>();
      */

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                ", added_at='" + added_at +
                '}';
    }
}
