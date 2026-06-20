package com.app.service.impl;

import com.app.converter.StudentConverter;
import com.app.entity.Student;
import com.app.model.StudentRequest;
import com.app.model.StudentResponse;
import com.app.repository.StudentRepository;
import com.app.service.StudentService;
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
        student.setFirstName(request.getFirstName());
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

//    @Override
//    public List<StudentResponse> searchStudent(String name) {
//        return studentRepository.findByNameContainingIgnoreCase(name)
//                .stream()
//                .map(studentConverter::mapToResponse)
//                .toList();
//    }

    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=students.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("FIRST_NAME");
        headerRow.createCell(1).setCellValue("LAST_NAME");
        headerRow.createCell(2).setCellValue("EMAIL");
//        headerRow.createCell(3).setCellValue("ADDRESS");
//        headerRow.createCell(4).setCellValue("DEPARTMENT");
//        headerRow.createCell(5).setCellValue("COURSE");

        List<StudentResponse> students = getAllStudents();

        int rowNum = 1;
        for (StudentResponse student : students) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getSid());
            row.createCell(1).setCellValue(student.getLastName());
            row.createCell(2).setCellValue(student.getEmail());
//            row.createCell(3).setCellValue(student.getAddress());
//            row.createCell(4).setCellValue(student.getDepartment());
//            row.createCell(5).setCellValue(student.getEmail());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }


}
