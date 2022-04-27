package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "John"),
            new Student(2, "Jane"),
            new Student(3, "Jack")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS.stream().filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow((() -> new IllegalStateException("Student "  + studentId + " not found")));
    }
}

