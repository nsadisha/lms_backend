package com.kln.lms.api.controller;

import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().body(userService.getAllStudents());
    }

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

    @GetMapping("/course/enrollStudent")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);


    }
}

@Data
class CourseToStudentForm{
    private Integer studentId;
    private Integer courseId;
}