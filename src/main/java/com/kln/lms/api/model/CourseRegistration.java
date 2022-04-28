package com.kln.lms.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"course_id", "student_id"}
        )
)

@Entity @NoArgsConstructor @AllArgsConstructor
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registration_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Float marks;

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Float getMarks() {
        return marks;
    }

    public void setMark(Float marks) {
        this.marks = marks;
    }

}
