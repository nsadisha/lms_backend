package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Course saveCourse(Course course);
    Student getStudent(Integer studentId);
    List<Student> getAllStudents();
    void addCourseToStudent(Integer studentId, Integer courseId);
}
