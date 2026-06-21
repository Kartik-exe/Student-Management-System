package com.app.model;

import com.schema.entity.Address;
import com.schema.entity.Course;
import com.schema.entity.Department;
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
