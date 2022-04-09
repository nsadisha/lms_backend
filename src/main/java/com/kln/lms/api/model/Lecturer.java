package com.kln.lms.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String staff_id;
    private String name;
    private String email;
    private String password;

    public String getStaff_id() {
        return staff_id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
