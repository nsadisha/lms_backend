package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView(View.CourseStudentRecursiveFilter.class)
    public Integer std_id;
    @JsonView(View.CourseStudentRecursiveFilter.class)
    private String name;
    @JsonView(View.CourseStudentRecursiveFilter.class)
    private String email;
    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Course> enrolledCourses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    @JsonView(View.CourseStudentRecursiveFilter.class)
    @JsonIgnoreProperties({"student"})
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
