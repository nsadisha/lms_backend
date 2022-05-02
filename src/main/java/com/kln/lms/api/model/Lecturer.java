package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Lecturer extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer")
    private List<Course> conductingCourses = new ArrayList<>();

    public Lecturer(Integer id, String name, String email, String password, String role) {
        super.setId(id);
        super.setName(name);
        super.setEmail(email);
        super.setPassword(password);
        super.setRole(role);
    }

    public List<Course> getConductingCourses() {
        return conductingCourses;
    }
}
