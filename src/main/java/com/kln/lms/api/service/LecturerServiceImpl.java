package com.kln.lms.api.service;

import com.kln.lms.api.model.CourseRegistration;
import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.CourseRegistrationRepository;
import com.kln.lms.api.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class LecturerServiceImpl implements UserService {

    private final LecturerRepository lecturerRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    public Lecturer getLecturer(Integer lecturerId) {
        log.info("Fetching Lecturer {}", lecturerId);
        return lecturerRepository.findById(lecturerId).orElseThrow();
    }

    public List<Student> getEnrolledStudents(Integer courseId){
        return courseRegistrationRepository.getEnrolledStudents(courseId);
    }

    public CourseRegistration assignMarks(Integer courseId, Integer studentId, Float marks) {
        courseRegistrationRepository.setMarks(studentId, courseId, marks);
        return courseRegistrationRepository.getCourseRegistration(studentId, courseId);
    }
}
