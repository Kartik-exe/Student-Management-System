package com.app.service;

import com.app.model.StudentRequest;
import com.app.model.StudentResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponse createStudent(StudentRequest request);

    StudentResponse updateStudent(Long id, StudentRequest request);

    List<StudentResponse> getAllStudents();

    Optional<StudentResponse> getStudentById(Long id);

    void deleteStudent(Long id);

//    List<StudentResponse> searchStudent(String name);

    void exportExcel(HttpServletResponse response) throws IOException;

}
