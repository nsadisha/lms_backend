package com.kln.lms.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String staff_number;
    public String name;
    public String faculty;
}
