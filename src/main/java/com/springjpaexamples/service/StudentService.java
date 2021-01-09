package com.springjpaexamples.service;

import com.springjpaexamples.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addNewStudent(Student student);
    Student findStudentByUsername(String username);
}
