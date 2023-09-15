package com.dialy.code.buffer.springboot.controller;

import com.dialy.code.buffer.springboot.dto.StudentDto;
import com.dialy.code.buffer.springboot.model.Student;
import com.dialy.code.buffer.springboot.response.ApiResponse;
import com.dialy.code.buffer.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) {

        StudentDto createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {

        StudentDto updateStudent = studentService.updateStudent(student, studentId);
        return new ResponseEntity<>(updateStudent, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") Long studentId) {

        StudentDto student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable("studentId") Long studentId) {

        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(new ApiResponse("Student deleted successfully "), HttpStatus.GONE);
    }
}
