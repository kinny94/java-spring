package com.springboot.app.dao;

import com.springboot.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// This is equivalent of creating your own dao and dao-impl
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
