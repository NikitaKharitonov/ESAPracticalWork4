package com.example.esapracticalwork4.model;

import java.util.function.Predicate;

public enum NotificationCondition {

    InsertCourseWhereHoursFrom10to20(change -> {
        if (!change.getType().equals(DbChange.Type.INSERT))
            return false;
        if (!change.getEntitySimpleName().equals(Course.class.getSimpleName()))
            return false;
        long hours = Long.parseLong(change.getNewEntityMap().get("hours"));
        return hours >= 10 && hours <= 20;
    }),
    InsertStudentWhereFirstNameStartsWithN(change -> change.getType().equals(DbChange.Type.INSERT)
            && change.getEntitySimpleName().equals(Student.class.getSimpleName())
            && change.getNewEntityMap().get("firstName").charAt(0) == 'N'
    ),
    DeleteGroup(change -> change.getType().equals(DbChange.Type.DELETE)
            && change.getEntitySimpleName().equals(Group.class.getSimpleName())
    );

    private final Predicate<DbChange> predicate;

    NotificationCondition(Predicate<DbChange> predicate) {
        this.predicate = predicate;
    }

    public boolean match(DbChange change) {
        return predicate.test(change);
    }
}
