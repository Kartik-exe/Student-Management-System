package com.studentmanagementsystem.StudentManagementSystem.controller;

import com.studentmanagementsystem.StudentManagementSystem.model.StudentRequest;
import com.studentmanagementsystem.StudentManagementSystem.model.StudentResponse;
import com.studentmanagementsystem.StudentManagementSystem.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    @Operation(summary = "Create student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @PutMapping("/update")
    @Operation(summary = "Update student")
    public ResponseEntity<StudentResponse> updateStudent(@RequestParam Long id,
                                                         @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(id, request));
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/id")
    @Operation(summary = "Get student by id")
    public ResponseEntity<StudentResponse> getStudentById(@RequestParam Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    @Operation(summary = "Delete student")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/search")
    @Operation(summary = "Search student")
    public ResponseEntity<List<StudentResponse>> searchStudent(@RequestParam String name) {
        return ResponseEntity.ok(studentService.searchStudent(name));
    }

    @GetMapping("/export")
    @Operation(summary = "Export student details in an Excel")
    public void exportExcel(HttpServletResponse response) throws IOException {
       studentService.exportExcel(response);
    }

}
