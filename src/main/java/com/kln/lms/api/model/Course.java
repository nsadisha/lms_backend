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

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    public Integer getCourseId() {
        return course_id;
    }
    public String getName() {
        return name;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        courseRegistrations.add(courseRegistration);
    }

    public List<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

}
