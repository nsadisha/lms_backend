package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private String name;

    @ManyToOne
    private Lecturer lecturer;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "std_id")
    )
    @JsonIgnore
    private List<Student> enrolledStudents = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Mark> marks = new ArrayList<>();

    public Integer getCourseId() {
        return course_id;
    }
    public String getName() {
        return name;
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    public List<Mark> getMarks() {
        return marks;
    }
    public void assignMarks(Mark mark){
        marks.add(mark);
    }
}
