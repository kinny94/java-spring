package com.spring.hibernatecrud.dao;
import com.spring.hibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    Student update(Student student);
    void updateAllLastName(String lastName);
    Student deleteById(int id);
    int deleteAllStudents();
    void setAutoIncrement();
}
