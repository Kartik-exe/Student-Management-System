package com.studentmanagementsystem.StudentManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentRequest {

    private long id;
    private String name;
    private String email;

}
