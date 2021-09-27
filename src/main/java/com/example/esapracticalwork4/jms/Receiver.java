package com.example.esapracticalwork4.jms;

import com.example.esapracticalwork4.model.DbChange;
import com.example.esapracticalwork4.service.ChangeService;
import com.example.esapracticalwork4.service.EmailSenderService;
import com.example.esapracticalwork4.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private ChangeService changeService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = "dbChange", containerFactory = "myFactory")
    public void receiveMessage(DbChange dbChange) {
        // insert into db
        changeService.save(dbChange);
        // send emails
        String subject = "DB change";
        String text = createEmailText(dbChange);
        notificationService.getAll().forEach(notification -> {
            if (notification.getCondition().match(dbChange)) {
                System.out.println("Sending email to " + notification.getEmailAddress() + "\n" + "Subject: " + subject + "\n" + "Text: " + text);
//                emailSenderService.sendEmail(notification.getEmailAddress(), subject, text);
            }
        });
    }

    private String createEmailText(DbChange dbChange) {
        StringBuilder text = new StringBuilder()
                .append("Change type: ").append(dbChange.getType()).append("\n")
                .append("Entity name: ").append(dbChange.getEntitySimpleName()).append("\n")
                .append("Entity ID: ").append(dbChange.getEntityId()).append("\n");
        if (dbChange.getOldEntityString() != null)
            text.append("Old entity data: ").append(dbChange.getOldEntityString()).append("\n");
        if (dbChange.getNewEntityString() != null)
            text.append("New entity data: ").append(dbChange.getNewEntityString()).append("\n");
        return text.toString();
    }

}
