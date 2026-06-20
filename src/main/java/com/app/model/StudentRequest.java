package com.app.model;

import com.app.entity.Address;
import com.app.entity.Course;
import com.app.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentRequest {

    private long sid;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private Course course;
    private Address address;

}
