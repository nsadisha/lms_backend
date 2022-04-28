package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private String name;

    @ManyToOne
    private Lecturer lecturer;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseRegistration> courseRegistrations = new HashSet<>();

    public Integer getCourseId() {
        return course_id;
    }
    public String getName() {
        return name;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        courseRegistrations.add(courseRegistration);
    }

    public Set<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

}
