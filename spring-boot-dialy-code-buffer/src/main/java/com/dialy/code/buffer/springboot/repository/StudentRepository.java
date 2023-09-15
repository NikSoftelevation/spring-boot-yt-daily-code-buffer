package com.dialy.code.buffer.springboot.repository;

import com.dialy.code.buffer.springboot.model.Student;
import com.dialy.code.buffer.springboot.service.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Optional<Student> findByEmail(String email);
}
