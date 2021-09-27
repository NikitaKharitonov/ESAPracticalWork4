package com.example.esapracticalwork4.controller.rest_api.xml;

import com.example.esapracticalwork4.model.Course;
import com.example.esapracticalwork4.model.Group;
import com.example.esapracticalwork4.model.Student;
import com.example.esapracticalwork4.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/xml/groups", produces = MediaType.APPLICATION_XML_VALUE)
public class GroupXmlRestController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public void create(@RequestBody Group group) {
        groupService.create(group);
    }

    @GetMapping
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public Group get(@PathVariable Long id) {
        return groupService.get(id);
    }

    @PatchMapping("/{groupId}/update")
    public void update(@PathVariable Long groupId, @RequestBody Group group) {
        groupService.update(groupId, group);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCourses(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("groupId", String.valueOf(id));
        return new ResponseEntity<>(groupService.getCourses(id), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getStudents(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("groupId", String.valueOf(id));
        return new ResponseEntity<>(groupService.getStudents(id), httpHeaders, HttpStatus.OK);
    }
}
