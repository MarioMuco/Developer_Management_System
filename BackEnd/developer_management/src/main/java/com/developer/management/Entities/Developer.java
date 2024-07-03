package com.developer.management.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String first_name;
    private String last_name;
    private String skills;
    private String experience;
    private String profile_photo;

    public Developer() {}

    public Developer(String firstname, String lastname, String skills, String experience, String photo) {
        this.first_name = firstname;
        this.last_name = lastname;
        this.skills = skills;
        this.experience = experience;
        this.profile_photo = photo;
    }

    @ManyToMany
    @JoinTable(
            name = "developer_project",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstname='" + first_name + '\'' +
                ", lastname='" + last_name + '\'' +
                ", skills='" + skills + '\'' +
                ", experience='" + experience + '\'' +
                ", photo='" + profile_photo + '\'' +
                '}';
    }
}
