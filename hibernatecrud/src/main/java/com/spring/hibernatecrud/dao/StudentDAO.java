package com.spring.hibernatecrud.dao;
import com.spring.hibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
