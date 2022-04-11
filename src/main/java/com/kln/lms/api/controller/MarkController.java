package com.kln.lms.api.controller;

import com.kln.lms.api.model.Mark;
import com.kln.lms.api.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    private final MarkRepository markRepository;

    @Autowired
    public MarkController(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @GetMapping("/student/{studentId}")
    public List<Mark> getAllMarks(@PathVariable Integer studentId){
        return markRepository.getAllMarks(studentId);
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public Mark getMarksForCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        return markRepository.getMarks(studentId, courseId);
    }
}
