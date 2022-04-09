package com.kln.lms.api.controller;

import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturerController {
    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerController(LecturerRepository lecturerRepository){
        this.lecturerRepository = lecturerRepository;
    }

    @PostMapping("/lecturer/signup")
    public void signupLecturer(@RequestBody Lecturer lecturer){
        lecturerRepository.save(lecturer);
    }
}
