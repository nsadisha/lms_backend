package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        )
)

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer std_id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "enrolledStudents")
    private Collection<Course> enrolledCourses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Mark> marks= new ArrayList<>();


    public Integer getStd_id() {
        return std_id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Collection<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public List<Mark> getMarks() {
        return marks;
    }
}
