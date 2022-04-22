package com.kln.lms.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Lecturer extends User{
    private String a;

    public Lecturer(Integer id, String name, String email, String password, String role) {
        super.setId(id);
        super.setName(name);
        super.setEmail(email);
        super.setPassword(password);
        super.setRole(role);
    }
}
