package com.example.esapracticalwork4.repository;

import com.example.esapracticalwork4.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
