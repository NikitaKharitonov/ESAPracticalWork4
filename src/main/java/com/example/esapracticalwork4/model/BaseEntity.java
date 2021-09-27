package com.example.esapracticalwork4.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Map;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract Map<String, String> toMap();
}
