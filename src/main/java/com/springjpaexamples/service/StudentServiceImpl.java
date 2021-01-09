package com.springjpaexamples.service;

import com.springjpaexamples.entity.Student;
import com.springjpaexamples.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentByUsername(String username) {
        return studentRepository.findByEmail(username);
    }
}
