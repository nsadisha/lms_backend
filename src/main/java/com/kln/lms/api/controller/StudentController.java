package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;

    @PutMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<?> enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        userService.addCourseToStudent(courseId, studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(userService.getStudent(studentId));
    }

}
