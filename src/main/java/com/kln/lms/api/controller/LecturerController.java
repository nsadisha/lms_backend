package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Mark;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
import com.kln.lms.api.repository.MarkRepository;
import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.service.LecturerServiceImpl;
import com.kln.lms.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
@RequiredArgsConstructor
public class LecturerController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    private final LecturerServiceImpl lecturerService;

    @GetMapping("/{courseId}/students")
    List<Student> getEnrolledStudents(@PathVariable Integer courseId){
        return lecturerService.getEnrolledStudents(courseId);
    }

    @PutMapping("/{courseId}/student/{studentId}/mark/{marks}")
    Student assignMarks(@PathVariable Integer courseId, @PathVariable Integer studentId, @PathVariable Float marks){
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();

        Mark mark = new Mark(course, student, marks);

        course.assignMarks(mark);
        markRepository.save(mark);

        return student;
    }
}
