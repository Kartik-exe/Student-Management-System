package com.app.converter;

import com.app.model.StudentRequest;
import com.app.model.StudentResponse;
import com.schema.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setSid(student.getSid());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setAddress(student.getAddress());
        response.setDepartment(student.getDepartment());
        response.setCourse(student.getCourse());

        return response;
    }

    public Student mapToEntity(StudentRequest request) {
        Student student = new Student();

        student.setSid(request.getSid());
        student.setFirstName(request.getFirstName());
        student.setFirstName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddress(request.getAddress());
        student.setDepartment(request.getDepartment());
        student.setDepartment(request.getDepartment());
        student.setCourse(request.getCourse());

        return student;
    }
}
