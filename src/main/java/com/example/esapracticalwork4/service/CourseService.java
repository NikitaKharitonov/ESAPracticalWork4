package com.example.esapracticalwork4.service;

import com.example.esapracticalwork4.jms.Sender;
import com.example.esapracticalwork4.repository.CourseRepository;
import com.example.esapracticalwork4.repository.GroupRepository;
import com.example.esapracticalwork4.model.Course;
import com.example.esapracticalwork4.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private Sender sender;

    public void create(Course course, Long groupId) {
        Group group = groupRepository.getById(groupId);
        course.setGroup(group);
        course.setId(getNextId());
        sender.sendInsert(course);
        courseRepository.save(course);

    }

    public Course get(Long id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getAll() {
        return courseRepository.findAll().stream().sorted(Comparator.comparing(Course::getId)).collect(Collectors.toList());
    }

    public void update(Long courseId, Course newCourseData, Long groupId) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRepository.findById(groupId).get();

        newCourseData.setId(courseId);
        newCourseData.setGroup(group);
        sender.sendUpdate(course, newCourseData);

        course.setName(newCourseData.getName());
        course.setHours(newCourseData.getHours());
        course.setGroup(group);
        courseRepository.save(course);
    }

    public void delete(Long id) {
        Course course = courseRepository.findById(id).get();
        course.getGroup().getCourses().remove(course);
        courseRepository.deleteById(id);

        sender.sendDelete(course);
    }

    public Long getNextId() {
        long count = courseRepository.count();
        long id = ++count;
        while (courseRepository.existsById(id)) {
            ++id;
        }
        return id;
    }
}
