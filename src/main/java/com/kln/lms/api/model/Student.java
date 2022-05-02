package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Student extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<CourseRegistration> courseRegistrations = new ArrayList<>();

    public Student(Integer id, String name, String email, String password, String role) {
        super.setId(id);
        super.setName(name);
        super.setEmail(email);
        super.setPassword(password);
        super.setRole(role);
    }

    public List<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        courseRegistrations.add(courseRegistration);
    }
}
