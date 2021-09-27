package com.example.esapracticalwork4.repository;

import com.example.esapracticalwork4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
