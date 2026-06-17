package com.studentmanagementsystem.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "MARKS")
    private Integer marks;

    @Column(name = "GRADE")
    private String grade;

    @ManyToOne
    private Student student;
}
