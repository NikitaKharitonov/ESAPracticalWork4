package com.example.esapracticalwork4.controller.rest_api.xml;

import com.example.esapracticalwork4.model.Course;
import com.example.esapracticalwork4.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/xml/courses", produces = MediaType.APPLICATION_XML_VALUE)
public class CourseXmlRestController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public void create(@RequestBody Course course, @RequestAttribute Long groupId) {
        courseService.create(course, groupId);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.get(id);
    }

    @PatchMapping("/{courseId}/update")
    public void update(@PathVariable Long courseId, @RequestBody Course course, @RequestAttribute Long groupId) {
        courseService.update(courseId, course, groupId);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
