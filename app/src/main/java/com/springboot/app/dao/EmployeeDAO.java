package com.springboot.app.dao;

import com.springboot.app.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
