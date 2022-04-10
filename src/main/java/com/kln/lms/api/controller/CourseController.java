package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/getAll")
    List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/add")
    Course addNewCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    Course enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
        course.enrollStudent(student);
        return courseRepository.save(course);
    }
}
