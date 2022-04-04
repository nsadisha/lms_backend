package com.kln.lms.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String student_number;
    public String name;
    public int age;
    public String city;
    public String faculty;

    //todo: we will use getter setter pattern for this
}
