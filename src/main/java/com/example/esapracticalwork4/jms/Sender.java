package com.example.esapracticalwork4.jms;

import com.example.esapracticalwork4.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;
    private final String dbChangeDestination = "dbChange";

    public void sendInsert(BaseEntity entity) {
        jmsTemplate.convertAndSend(dbChangeDestination, new DbChange(DbChange.Type.INSERT, null, entity));
    }

    public void sendUpdate(BaseEntity oldEntity, BaseEntity newEntity) {
        jmsTemplate.convertAndSend(dbChangeDestination, new DbChange(DbChange.Type.UPDATE, oldEntity, newEntity));
    }

    public void sendDelete(BaseEntity entity) {
        jmsTemplate.convertAndSend(dbChangeDestination, new DbChange(DbChange.Type.DELETE, entity, null));
    }
}
