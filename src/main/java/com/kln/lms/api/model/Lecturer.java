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

    public Lecturer(User user) {
        super.setId(user.getId());
        super.setName(user.getName());
        super.setEmail(user.getEmail());
        super.setPassword(user.getPassword());
        super.setRole(user.getRole());
    }

    public List<Course> getConductingCourses() {
        return conductingCourses;
    }
}
