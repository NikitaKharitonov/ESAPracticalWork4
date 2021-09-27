package com.example.esapracticalwork4.controller.rest_api.json;

import com.example.esapracticalwork4.model.Student;
import com.example.esapracticalwork4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/json/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentJsonRestController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public void create(@RequestBody Student student, @RequestAttribute Long groupId) {
        studentService.create(student, groupId);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.get(id);
    }

    @PatchMapping("/{id}/update")
    public void update(@PathVariable("id") Long studentId, @RequestBody Student student, @RequestAttribute Long groupId) {
        studentService.update(studentId, student, groupId);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
