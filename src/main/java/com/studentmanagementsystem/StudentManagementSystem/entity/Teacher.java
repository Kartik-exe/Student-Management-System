package com.studentmanagementsystem.StudentManagementSystem.entity;

import com.studentmanagementsystem.StudentManagementSystem.constants.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.MediaSize;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "SALARY")
    private BigDecimal salary;

}
