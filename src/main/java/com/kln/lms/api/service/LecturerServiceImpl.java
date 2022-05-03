package com.kln.lms.api.service;

import com.kln.lms.api.emails.MailGunEmailService;
import com.kln.lms.api.emails.EmailModel;
import com.kln.lms.api.model.*;
import com.kln.lms.api.repository.AnnouncementRepository;
import com.kln.lms.api.repository.CourseRegistrationRepository;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
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

    public Announcement postAnnouncement(Integer courseId, Announcement announcement){
        //Todo: Email sending part should be integrated
        announcement.setCourse(
                courseRepository.findById(courseId).orElseThrow()
        );
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAnnouncements(Integer courseId){
        return announcementRepository.findAnnouncementsByCourseId(courseId);
    }

    public void sendEmails() throws IOException {
        EmailModel emails = new EmailModel("kittycatpurrrrrs@gmail.com", "Subject", "This is the body");
        emailService.sendEmail(emails);
    }
}
