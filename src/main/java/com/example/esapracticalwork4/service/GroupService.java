package com.example.esapracticalwork4.service;

import com.example.esapracticalwork4.jms.Sender;
import com.example.esapracticalwork4.model.Course;
import com.example.esapracticalwork4.model.Group;
import com.example.esapracticalwork4.model.Student;
import com.example.esapracticalwork4.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private Sender sender;

    public void create(Group group) {
        group.setId(getNextId());
        groupRepository.save(group);

        sender.sendInsert(group);
    }

    public Group get(Long id) {
        return groupRepository.findById(id).get();
    }

    public List<Group> getAll() {
        return groupRepository.findAll().stream().sorted(Comparator.comparing(Group::getId)).collect(Collectors.toList());
    }

    public void update(Long groupId, Group newGroupData) {
        Group group = groupRepository.findById(groupId).get();

        newGroupData.setId(groupId);
        sender.sendUpdate(group, newGroupData);

        group.setYear(newGroupData.getYear());
        groupRepository.save(group);
    }

    public void delete(Long id) {
        Group group = groupRepository.findById(id).get();
        groupRepository.deleteById(id);

        sender.sendDelete(group);
        group.getCourses().forEach(course -> sender.sendDelete(course));
        group.getStudents().forEach(student -> sender.sendDelete(student));
    }

    public List<Student> getStudents(Long id) {
        Group group = get(id);
        return group.getStudents().stream().sorted(Comparator.comparingLong(Student::getId)).collect(Collectors.toList());
    }

    public List<Course> getCourses(Long id) {
        Group group = get(id);
        return group.getCourses().stream().sorted(Comparator.comparingLong(Course::getId)).collect(Collectors.toList());
    }

    public Long getNextId() {
        long count = groupRepository.count();
        long id = ++count;
        while (groupRepository.existsById(id)) {
            ++id;
        }
        return id;
    }
}
