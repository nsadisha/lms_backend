package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Student extends User{
    @ManyToMany(mappedBy = "enrolledStudents")
    private Collection<Course> enrolledCourses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Mark> marks= new ArrayList<>();

    public Student(Integer id, String name, String email, String password, String role) {
        super.setId(id);
        super.setName(name);
        super.setEmail(email);
        super.setPassword(password);
        super.setRole(role);
    }

    public Collection<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public List<Mark> getMarks() {
        return marks;
    }
}
