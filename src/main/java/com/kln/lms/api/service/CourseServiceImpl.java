package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CourseServiceImpl {
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getInfo(Integer courseId){
        return courseRepository.findById(courseId).get();
    }

    public Course saveCourse(Course course, String email) {
        log.info("Saving new Course {}", course.getName());
        Lecturer lecturer = lecturerRepository.findLecturerByEmail(email);
        course.setLecturer(lecturer);
        lecturer.getConductingCourses().add(course);
        return courseRepository.save(course);
    }
}
