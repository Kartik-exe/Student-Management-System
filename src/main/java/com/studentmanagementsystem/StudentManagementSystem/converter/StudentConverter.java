package com.studentmanagementsystem.StudentManagementSystem.converter;

import com.studentmanagementsystem.StudentManagementSystem.entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.model.StudentRequest;
import com.studentmanagementsystem.StudentManagementSystem.model.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());

        return response;
    }

    public Student mapToEntity(StudentRequest request) {
        Student student = new Student();

        student.setId(request.getId());
        student.setName(request.getName());
        student.setEmail(request.getEmail());

        return student;
    }
}
