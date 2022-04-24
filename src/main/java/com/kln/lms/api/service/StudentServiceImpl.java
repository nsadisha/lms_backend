package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class StudentServiceImpl {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public Student getStudent(Integer studentId) {
        log.info("Fetching Student {}", studentId);
        return (Student) userRepository.findUserByIdAndRoleEquals(studentId, "STUDENT");
    }

    public void addStudentToCourse(Integer studentId, Integer courseId) {
        Student student = (Student) userRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        log.info("Adding course {} to student {}", course.getName(), student.getName());
        student.getEnrolledCourses().add(course);
        course.enrollStudent(student);
    }
}
