package com.kln.lms.api.controller;

import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().body(userService.getAllStudents());
    }

    private final StudentRepository studentRepository;

    @PostMapping("/signup")
    public ResponseEntity<Student> signupStudent(@RequestBody Student studentData) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("student/signup").toUriString());
        return ResponseEntity.created(uri).body(userService.saveStudent(studentData));
    }

    @PostMapping("/course/enrollStudent")
    public ResponseEntity<?> enrollStudent(@RequestBody CourseToStudentForm form) {
        userService.addCourseToStudent(form.getStudentId(), form.getCourseId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(userService.getStudent(studentId));
    }
}

@Data
class CourseToStudentForm{
    private Integer studentId;
    private Integer courseId;
}