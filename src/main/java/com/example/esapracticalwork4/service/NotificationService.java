package com.example.esapracticalwork4.service;

import com.example.esapracticalwork4.model.Notification;
import com.example.esapracticalwork4.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}
