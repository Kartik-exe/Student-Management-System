package com.studentmanagementsystem.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Attendance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ATTENDANCE_DATE")
    private LocalDate attendanceDate;

    @Column(name = "IS_PRESSENT")
    private Boolean present;

    @ManyToOne
    private Student student;

}
