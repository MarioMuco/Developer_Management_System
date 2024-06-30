package com.developer.management.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
