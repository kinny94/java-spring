package com.spring.rest.controller;

import com.spring.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Anthony", "Edwards", "anthony@edward.com"));
        students.add(new Student("Kevin", "Durant", "Kevin@durant.com"));
        students.add(new Student("Jayson", "Tatum", "Jason@Tatum.com"));
        students.add(new Student("Jaylen", "Brown", "Jaylen@brown.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return students.get(studentId);
    }
}
