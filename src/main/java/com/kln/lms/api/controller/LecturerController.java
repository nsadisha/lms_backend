package com.kln.lms.api.controller;

import com.kln.lms.api.model.*;
import com.kln.lms.api.response.StudentMarksResponse;
import com.kln.lms.api.service.LecturerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerServiceImpl lecturerService;

    @GetMapping("/{lecturerId}")
    Lecturer getLecturer(@PathVariable Integer lecturerId){
        return lecturerService.getLecturer(lecturerId);
    }

    @GetMapping("/{courseId}/students")
    List<Student> getEnrolledStudents(@PathVariable Integer courseId){
        return lecturerService.getEnrolledStudents(courseId);
    }

    @GetMapping("/{courseId}/students/marks")
    List<StudentMarksResponse> getEnrolledStudentsMarks(@PathVariable Integer courseId){
        return lecturerService.getEnrolledStudentsMarks(courseId);
    }

    @PostMapping("/{courseId}/student/{studentId}/mark/{marks}")
    CourseRegistration assignMarks(@PathVariable Integer courseId, @PathVariable Integer studentId, @PathVariable Float marks){
        return lecturerService.assignMarks(courseId, studentId, marks);
    }

    @PostMapping("/{courseId}/announcement")
    Announcement postAnnouncement(
            @RequestBody Announcement announcement,
            @PathVariable Integer courseId,
            @CurrentSecurityContext(expression="authentication?.Principal") String email){
        return lecturerService.postAnnouncement(courseId, announcement, email);
    }

    @GetMapping("/{lecturerId}/courses")
    List<Course> getConductingCourses(@PathVariable Integer lecturerId){
        return lecturerService.getConductingCourses(lecturerId);
    }
}
