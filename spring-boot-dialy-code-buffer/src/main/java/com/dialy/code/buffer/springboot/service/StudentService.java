package com.dialy.code.buffer.springboot.service;

import com.dialy.code.buffer.springboot.dto.StudentDto;
import com.dialy.code.buffer.springboot.model.Student;

import java.util.List;

public interface StudentService {
    public StudentDto addStudent(Student student);

    public StudentDto updateStudent(Student student, Long studentId);

    public List<Student> getAllStudents();

    public StudentDto getStudentById(Long studentId);

    void deleteStudent(Long studentId);
}
