package com.studentmanagementsystem.StudentManagementSystem.service.impl;

import com.studentmanagementsystem.StudentManagementSystem.converter.StudentConverter;
import com.studentmanagementsystem.StudentManagementSystem.entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.model.StudentRequest;
import com.studentmanagementsystem.StudentManagementSystem.model.StudentResponse;
import com.studentmanagementsystem.StudentManagementSystem.repository.StudentRepository;
import com.studentmanagementsystem.StudentManagementSystem.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    @Override
    public StudentResponse createStudent(StudentRequest request) {

        Student student = studentConverter.mapToEntity(request);
        Student savedStudent = studentRepository.save(student);

        return studentConverter.mapToResponse(savedStudent);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(request.getName());
        student.setEmail(request.getEmail());

        Student updatedStudent = studentRepository.save(student);

        return studentConverter.mapToResponse(updatedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentConverter::mapToResponse)
                .toList();
    }

    @Override
    public Optional<StudentResponse> getStudentById(Long id) {
        return studentRepository.findById(id).map(studentConverter::mapToResponse);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponse> searchStudent(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(studentConverter::mapToResponse)
                .toList();
    }

    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=students.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("NAME");
        headerRow.createCell(2).setCellValue("EMAIL");

        List<StudentResponse> students = getAllStudents();

        int rowNum = 1;
        for (StudentResponse student : students) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getEmail());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }


}
