package com.kln.lms.api.repository;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.CourseRegistration;
import com.kln.lms.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {

    @Query("SELECT cr.student FROM CourseRegistration cr WHERE cr.course.course_id = ?1")
    List<Student> getEnrolledStudents(Integer courseId);
//    List<Student> findCourseRegistrationsByCourse_CourseId(Integer courseId);

    @Query("SELECT cr.course FROM CourseRegistration cr WHERE cr.student.id = ?1")
    List<Course> getEnrolledCourses(Integer studentId);

    @Query(value = "SELECT cr.marks FROM CourseRegistration cr WHERE cr.student.id = ?1 AND cr.course.course_id = ?2")
    Float getMarks(Integer studentId, Integer courseId);

    @Modifying
    @Query(value = "UPDATE CourseRegistration SET marks = ?3 WHERE student.id = ?1 AND course.course_id = ?2")
    void setMarks(Integer studentId, Integer courseId, Float marks);

    @Query(value = "SELECT cr FROM CourseRegistration cr WHERE cr.student.id = ?1 AND cr.course.course_id = ?2")
    CourseRegistration getCourseRegistration(Integer studentId, Integer courseId);

}
