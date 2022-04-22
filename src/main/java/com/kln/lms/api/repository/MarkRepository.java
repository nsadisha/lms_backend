package com.kln.lms.api.repository;

import com.kln.lms.api.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "SELECT m FROM Mark m WHERE m.student.id = ?1 AND m.course.course_id = ?2")
    Mark getMarks(Integer studentId, Integer courseId);

    @Query(value = "SELECT m FROM Mark m WHERE m.student.id = ?1")
    List<Mark> getAllMarks(Integer studentId);
}
