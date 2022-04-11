package com.kln.lms.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        )
)

@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String staff_id;
    private String name;
    private String email;
    @JsonIgnore
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
