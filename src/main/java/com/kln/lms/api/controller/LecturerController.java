package com.kln.lms.api.controller;

import com.kln.lms.api.model.Announcement;
import com.kln.lms.api.model.CourseRegistration;
import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.service.LecturerServiceImpl;
import lombok.RequiredArgsConstructor;
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

    @PutMapping("/{courseId}/student/{studentId}/mark/{marks}")
    CourseRegistration assignMarks(@PathVariable Integer courseId, @PathVariable Integer studentId, @PathVariable Float marks){
        return lecturerService.assignMarks(courseId, studentId, marks);
    }

    @PostMapping("/{courseId}/announcement")
    Announcement postAnnouncement(@RequestBody Announcement announcement, @PathVariable Integer courseId){
        return lecturerService.postAnnouncement(courseId, announcement);
    }
}
