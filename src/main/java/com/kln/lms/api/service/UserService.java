package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;

import java.util.List;

public interface UserService {
    Student saveStudent(Student student);
    Course saveCourse(Course course);
    Student getStudent(Integer studentId);
    List<Student> getAllStudents();
    void addCourseToStudent(Integer studentId, Integer courseId);
}
