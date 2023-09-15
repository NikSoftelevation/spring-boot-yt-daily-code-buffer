package com.dialy.code.buffer.springboot.service.impl;

import com.dialy.code.buffer.springboot.dto.StudentDto;
import com.dialy.code.buffer.springboot.exception.StudentAlreadyExistsException;
import com.dialy.code.buffer.springboot.model.Student;
import com.dialy.code.buffer.springboot.repository.StudentRepository;
import com.dialy.code.buffer.springboot.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())) {

            throw new StudentAlreadyExistsException("Student already exists " + student.getEmail());

        }
        Student createdStudent = studentRepository.save(student);
        return modelMapper.map(createdStudent, StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(Student student, Long studentId) {

        Student oldStudent = studentRepository.findById(studentId).get();

        oldStudent.setId(student.getId());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setDepartment(student.getDepartment());
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());

        Student savedStudent = studentRepository.save(oldStudent);

        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> studentsList = studentRepository.findAll();
        return studentsList;
    }

    @Override
    public StudentDto getStudentById(Long studentId) {

        Student studentById = studentRepository.findById(studentId).get();

        return modelMapper.map(studentById, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long studentId) {

        studentRepository.deleteById(studentId);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
