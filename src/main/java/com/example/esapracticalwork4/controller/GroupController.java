package com.example.esapracticalwork4.controller;

import com.example.esapracticalwork4.model.Course;
import com.example.esapracticalwork4.model.Group;
import com.example.esapracticalwork4.model.Student;
import com.example.esapracticalwork4.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute(new Group());
        return "create_group";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Group group) {
        groupService.create(group);
        return "redirect:/groups";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Group> groups = groupService.getAll();
        model.addAttribute("groups", groups);
        return "show_groups";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long groupId, Model model) {
        model.addAttribute("group", groupService.get(groupId));
        return "update_group";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long groupId, @ModelAttribute Group group) {
        groupService.update(groupId, group);
        return "redirect:/groups";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        groupService.delete(id);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/courses")
    public String getCourses(@PathVariable Long id, Model model) {
        List<Course> courses = groupService.getCourses(id);
        model.addAttribute("courses", courses);
        model.addAttribute("id", id);
        return "show_group_courses";
    }

    @GetMapping("/{id}/students")
    public String getStudents(@PathVariable Long id, Model model) {
        List<Student> students = groupService.getStudents(id);
        model.addAttribute("students", students);
        model.addAttribute("id", id);
        return "show_group_students";
    }
}
