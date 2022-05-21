package com.kln.lms.api.response;

import com.kln.lms.api.model.Student;

public class StudentMarksResponse extends Student {

    public Float marks;

    public StudentMarksResponse(Student student, Float marks){
        super(student);
        this.marks = marks;
    }
}
