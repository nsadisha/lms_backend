package com.kln.lms.api.service;

import com.kln.lms.api.model.Announcement;
import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.CourseRegistration;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.repository.AnnouncementRepository;
import com.kln.lms.api.repository.CourseRegistrationRepository;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class StudentServiceImpl {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final AnnouncementRepository announcementRepository;

    public Student getStudent(Integer studentId) {
        log.info("Fetching Student {}", studentId);
        return studentRepository.findById(studentId).orElseThrow();
    }

    public List<Course> getEnrolledCourses(Integer studentId){
        log.info("Fetching all enrolled courses for student {}", studentId);
        return courseRegistrationRepository.getEnrolledCourses(studentId);
    }

    public void addStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        log.info("Adding course {} to student {}", course.getName(), student.getName());

        CourseRegistration courseRegistration = new CourseRegistration(null, course, student, null);
        courseRegistrationRepository.save(courseRegistration);

        student.setCourseRegistration(courseRegistration);
        course.setCourseRegistration(courseRegistration);

    }

    public List<Announcement> getAnnouncements(Integer courseId) {
        log.info("Announcements from course id: "+courseId);
        return announcementRepository.findAnnouncementsByCourseId(courseId);
    }
}
