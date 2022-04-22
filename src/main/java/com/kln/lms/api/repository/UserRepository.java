package com.kln.lms.api.repository;

import com.kln.lms.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserByIdAndRoleEquals(Integer id, String role);
}
