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

    public Student(User user) {
        super.setId(user.getId());
        super.setName(user.getName());
        super.setEmail(user.getEmail());
        super.setPassword(user.getPassword());
        super.setRole(user.getRole());
    }

    public List<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        courseRegistrations.add(courseRegistration);
    }
}
