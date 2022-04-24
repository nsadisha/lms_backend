package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Mark;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.MarkRepository;
import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    private final UserService userService;

    @GetMapping("/all")
    List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Integer courseId){
        return ResponseEntity.ok().body(courseRepository.findById(courseId));
    }

    @PostMapping("/add")
    Course addNewCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

}
