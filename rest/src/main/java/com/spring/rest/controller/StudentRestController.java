package com.spring.rest.controller;

import com.spring.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Anthony", "Edwards", "anthony@edward.com"));
        students.add(new Student("Kevin", "Durant", "Kevin@durant.com"));
        students.add(new Student("Jayson", "Tatum", "Jason@Tatum.com"));
        students.add(new Student("Jaylen", "Brown", "Jaylen@brown.com"));
        return students;
    }
}
