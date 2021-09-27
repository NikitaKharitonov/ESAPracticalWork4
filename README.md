# Practical work #4 for Enterprise Systems Architecture course 
 
- JDK 16.0.2
- Spring Boot 2.5.5
- PostgreSQL 13.3
- Intellij IDEA Ultimate 2021.2.1

This project is the same as [ESAPracticalWork3](https://github.com/NikitaKharitonov/ESAPracticalWork3) but
is implemented with Spring Boot instead of Spring Framework and also has
a logging mechanism and a “watchdog” for a specific kind of changes.

### Task 1
A new table/entity was added:

DbChange - represents a change of information in other tables of the database.

Its fields:
- type - type of change, possible values: insert, update, delete;
- entityId - the ID of the changing entity;
- entitySimpleName - the simple name of the changing entity, possible values: Student, Group, Course;
- oldEntityString - the string representation of the old entity (it is null, if the type of change is 'insert');
- newEntityString - the string representation of the new entity (it is null, if the type of change is 'delete').

### Task 2
Two classes were created to handle the JMS logic: Sender and Receiver.
Sender creates a DbChange object and sends it to Receiver. Receiver checks the DbChange object and saves it to the DB 
and sends notification emails.

### Task 3
The implemented Sender bean was added to the services to send messages whenever the DB is changed.

### Task 4
The Receiver receives these messages and a record into the 'db_change' table.

### Task 5
A new table/entity was added:

Notification - contains an email address for notification, and condition.

Its fields: 
- emailAddress - where to send the notification;
- notificationCondition - when to send the notification.

NotificationCondition is an enum each constant of which has an associated predicate. This predicate is applied to 
the DbChange object to determine if the notification must be sent or not. 

### Task 6
The Receiver uses EmailManagerService to send emails.

### Task 7
The project runs with Spring Boot and PostgreSQL.



