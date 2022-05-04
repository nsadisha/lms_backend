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

    @Column (unique = true)
    private String course_code;
    private String name;
    @Column( columnDefinition = "LONGTEXT")
    private String description;

    @ManyToOne
    private Lecturer lecturer;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseRegistration> courseRegistrations = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Announcement> announcements = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        courseRegistrations.add(courseRegistration);
    }
}
