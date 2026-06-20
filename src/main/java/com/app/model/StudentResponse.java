package com.app.model;

import com.app.entity.Address;
import com.app.entity.Course;
import com.app.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponse {

    private long sid;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Department department;
    private Course course;

}
