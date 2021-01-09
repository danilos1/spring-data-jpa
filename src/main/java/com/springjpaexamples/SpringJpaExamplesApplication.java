package com.springjpaexamples;

import com.springjpaexamples.entity.Student;
import com.springjpaexamples.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class SpringJpaExamplesApplication {
    public static final String[] studentFirstNames = {
            "jack", "anna", "danil", "linda",
            "kate", "betty", "tim", "denis",
            "linda", "maria", "jim", "margot"
    };

    public static final String[] studentLastNames = {
            "brown", "tackle", "lack", "robbie",
            "nolan", "reitch", "los", "dydro",
            "vary", "daily", "lombok", "jojo"
    };

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaExamplesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int one = random.nextInt(12);
                int two = random.nextInt(12);
                String fN = studentFirstNames[one];
                String lN = studentLastNames[two];
                Student student = new Student(fN, lN, fN+lN+i, i);
                studentRepository.save(student);
            }
        };
    }
}
