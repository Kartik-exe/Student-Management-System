package com.app.model;

import com.schema.entity.Address;
import com.schema.entity.Course;
import com.schema.entity.Department;
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
