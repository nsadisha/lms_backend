package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        )
)

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer std_id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Course> enrolledCourses = new ArrayList<>();

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
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public List<Mark> getMarks() {
        return marks;
    }
}
