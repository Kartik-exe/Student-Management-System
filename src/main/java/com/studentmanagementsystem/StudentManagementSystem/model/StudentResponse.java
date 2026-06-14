package com.studentmanagementsystem.StudentManagementSystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponse {

    private long id;
    private String name;
    private String email;

}
