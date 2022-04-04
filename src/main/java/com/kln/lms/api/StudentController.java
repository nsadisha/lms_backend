package com.kln.lms.api;

import com.kln.lms.api.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String index(){
        return "Hello this is index page..";
    }

    @GetMapping("/name")
    public String getName(){
        return studentRepository.findAll().get(0).name;
    }
    @GetMapping("/all")
    public String getAll(){
        return String.valueOf(studentRepository.count());
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student studentData) {
        studentRepository.save(studentData);
    }

}
