package com.kln.lms.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kln.lms.api.model.View;
import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/signup")
    public Student signupStudent(@RequestBody Student studentData) {
        return studentRepository.save(studentData);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return studentRepository.findById(studentId).get();
    }
}
