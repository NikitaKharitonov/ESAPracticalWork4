package com.example.esapracticalwork4.repository;

import com.example.esapracticalwork4.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
