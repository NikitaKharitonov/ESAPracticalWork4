package com.example.esapracticalwork4.service;

import com.example.esapracticalwork4.model.DbChange;
import com.example.esapracticalwork4.repository.ChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeService {

    @Autowired
    private ChangeRepository changeRepository;

    public void save(DbChange change) {
        change.setId(getNextId());
        changeRepository.save(change);
    }

    public Long getNextId() {
        long count = changeRepository.count();
        long id = ++count;
        while (changeRepository.existsById(id)) {
            ++id;
        }
        return id;
    }
}
