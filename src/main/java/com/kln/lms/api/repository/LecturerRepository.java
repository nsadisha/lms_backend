package com.kln.lms.api.repository;

import com.kln.lms.api.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {
}
