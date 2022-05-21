package com.kln.lms.api.service;

import com.kln.lms.api.emails.MailGunEmailService;
import com.kln.lms.api.emails.EmailModel;
import com.kln.lms.api.model.*;
import com.kln.lms.api.repository.AnnouncementRepository;
import com.kln.lms.api.repository.CourseRegistrationRepository;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
import com.kln.lms.api.response.StudentMarksResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class LecturerServiceImpl implements UserService {

    private final LecturerRepository lecturerRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final AnnouncementRepository announcementRepository;
    private final MailGunEmailService emailService;

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

    @SneakyThrows
    public Announcement postAnnouncement(Integer courseId, Announcement announcement){

        List<Student> enrolledStudents = getEnrolledStudents(courseId);
        for (Student enrolledStudent : enrolledStudents) {
            EmailModel emailModel = new EmailModel(enrolledStudent.getEmail(),announcement.getTitle(),announcement.getDescription());
            emailService.sendEmail(emailModel);
        }

        announcement.setCourse(
                courseRepository.findById(courseId).orElseThrow()
        );
        return announcementRepository.save(announcement);
    }

    public List<StudentMarksResponse> getEnrolledStudentsMarks(Integer courseId) {

        List<Float> marks = courseRegistrationRepository.getStudentsMarks(courseId);
        List<Student> students = courseRegistrationRepository.getEnrolledStudents(courseId);

        List<StudentMarksResponse> studentMarksResponses = new ArrayList<>();

        for (int i=0; i < students.size(); i++) {
            studentMarksResponses.add(new StudentMarksResponse(students.get(i), marks.get(i)));
        }

        return studentMarksResponses;
    }
}
