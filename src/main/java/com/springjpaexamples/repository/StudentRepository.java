package com.springjpaexamples.repository;

import com.springjpaexamples.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

}
