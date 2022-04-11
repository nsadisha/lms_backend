package com.kln.lms.api.model;

import javax.persistence.*;

@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"courseId", "stdId"}
        )
)

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mark_id;


    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    private Float marks;

    public Mark(){}

    public Mark(Course course, Student student, Float marks) {
        this.course = course;
        this.student = student;
        this.marks = marks;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Float getMarks() {
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
    }
}
