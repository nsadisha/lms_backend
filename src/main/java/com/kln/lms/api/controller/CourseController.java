package com.kln.lms.api.controller;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Mark;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.MarkRepository;
import com.kln.lms.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    @GetMapping("/getAll")
    List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/add")
    Course addNewCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/{courseId}/students")
    List<Student> getEnrolledStudents(@PathVariable Integer courseId){
        return courseRepository.getEnrolledStudents(courseId);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    Course enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
        course.enrollStudent(student);
        return courseRepository.save(course);
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
