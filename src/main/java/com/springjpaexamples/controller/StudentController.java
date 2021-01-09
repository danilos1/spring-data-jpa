package com.springjpaexamples.controller;

import java.util.List;
import com.springjpaexamples.entity.Student;
import com.springjpaexamples.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student";
    }

    @PostMapping
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        return ResponseEntity.ok("The student "+student.getFirstName()+" "+student.getLastName()+" was created successfully!");
    }
}
