package com.example.esapracticalwork4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Entity
public class Course extends BaseEntity {

    private String name;

    private Integer hours;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Course() {
    }

    public Course(String name, Integer hours) {
        this.name = name;
        this.hours = hours;
    }

    public Course(String name, Integer hours, Group group) {
        this.name = name;
        this.hours = hours;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return toMap().toString();
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("hours", hours.toString());
        map.put("groupId", group.getId().toString());
        return map;
    }
}
