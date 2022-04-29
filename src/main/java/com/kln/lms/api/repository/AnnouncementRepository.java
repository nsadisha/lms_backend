package com.kln.lms.api.repository;

import com.kln.lms.api.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    @Query(value = "SELECT a FROM Announcement a WHERE a.course.course_id = ?1")
    List<Announcement> findAnnouncementsByCourseId(Integer id);
}
