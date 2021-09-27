package com.example.esapracticalwork4.repository;

import com.example.esapracticalwork4.model.DbChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeRepository extends JpaRepository<DbChange, Long> {
}
