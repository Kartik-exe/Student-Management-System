package com.studentmanagementsystem.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "HOD_NAME")
    private String hodName;

}
