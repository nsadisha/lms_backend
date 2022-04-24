package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CourseServiceImpl {
    private final CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getInfo(Integer courseId){
        return courseRepository.findById(courseId).get();
    }

    public Course saveCourse(Course course) {
        log.info("Saving new Course {}", course.getName());
        return courseRepository.save(course);
    }
}
