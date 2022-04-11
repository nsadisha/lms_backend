package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.CourseStudentRecursiveFilter.class, View.IgnoreEnrolledCoursesFilter.class})
    private Integer course_id;
    @JsonView({View.CourseStudentRecursiveFilter.class, View.IgnoreEnrolledCoursesFilter.class})
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "stdId")
    )
    private List<Student> enrolledStudents = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties({"course", "enrolledStudents"})
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
