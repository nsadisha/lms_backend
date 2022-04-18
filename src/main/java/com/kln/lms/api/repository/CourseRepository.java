package com.kln.lms.api.repository;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("SELECT c.enrolledStudents FROM Course c WHERE c.course_id = ?1")
    List<Student> getEnrolledStudents(Integer courseId);
}
