package com.example.esapracticalwork4.service;

import com.example.esapracticalwork4.jms.Sender;
import com.example.esapracticalwork4.model.Student;
import com.example.esapracticalwork4.repository.GroupRepository;
import com.example.esapracticalwork4.repository.StudentRepository;
import com.example.esapracticalwork4.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private Sender sender;

    public void create(Student student, Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        student.setGroup(group);
        student.setId(getNextId());
        studentRepository.save(student);

        sender.sendInsert(student);
    }

    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll() {
        return studentRepository.findAll().stream().sorted(Comparator.comparingLong(Student::getId)).collect(Collectors.toList());
    }

    public void update(Long studentId, Student newStudentData, Long groupId) {
        Student student = studentRepository.findById(studentId).get();
        Group group = groupRepository.findById(groupId).get();

        newStudentData.setId(studentId);
        newStudentData.setGroup(group);
        sender.sendUpdate(student, newStudentData);

        student.setFirstName(newStudentData.getFirstName());
        student.setLastName(newStudentData.getLastName());
        student.setDateOfBirth(newStudentData.getDateOfBirth());
        student.setGroup(group);
        studentRepository.save(student);
    }

    public void delete(Long id) {
        Student student = studentRepository.findById(id).get();
        student.getGroup().getStudents().remove(student);
        studentRepository.deleteById(id);

        sender.sendDelete(student);
    }

    public Long getNextId() {
        long count = studentRepository.count();
        long id = ++count;
        while (studentRepository.existsById(id)) {
            ++id;
        }
        return id;
    }

}
