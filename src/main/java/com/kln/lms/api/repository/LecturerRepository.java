package com.kln.lms.api.repository;

import com.kln.lms.api.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {
    Lecturer findLecturerByEmail(String email);
}
