package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRegistrationRepository;
import com.kln.lms.api.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(studentService.getStudent(studentId));
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<?> enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        studentService.addStudentToCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{studentId}/unenroll/{courseId}")
    public ResponseEntity<?> unEnrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        studentService.removeStudentFromCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getEnrolledCourses(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(studentService.getEnrolledCourses(studentId));
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Float> getMarksForCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        return ResponseEntity.ok().body(courseRegistrationRepository.getMarks(studentId, courseId));
    }
}
