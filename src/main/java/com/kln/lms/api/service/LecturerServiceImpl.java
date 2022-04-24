package com.kln.lms.api.service;

import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class LecturerServiceImpl implements UserService {
    private final LecturerRepository lecturerRepository;
    private final CourseRepository courseRepository;

    public List<Student> getEnrolledStudents(Integer courseId){
        return courseRepository.getEnrolledStudents(courseId);
    }
}
