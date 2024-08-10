package com.springboot.app.service;

import com.springboot.app.entity.Employee;

import java.util.List;

public interface EmployeeRepoService {
    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(int id);
    void deleteById(int id);
}
