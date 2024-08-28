package com.springboot.app.rest;

import com.springboot.app.entity.Employee;
import com.springboot.app.service.EmployeeRepoService;
import com.springboot.app.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private EmployeeRepoService employeeRepoService;

    EmployeeRestController(EmployeeService employeeService, EmployeeRepoService employeeRepoService) {
        this.employeeService = employeeService;
        this.employeeRepoService = employeeRepoService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        // return employeeService.findAll();
        return employeeRepoService.findAll();
    }

    @GetMapping("/ /{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeRepoService.findById(employeeId);
        if (employee == null) {
           throw new RuntimeException("Employee id not found..." + employeeId);
        }
        return employee;
    }

    @PostMapping("employees/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeRepoService.save(employee);
    }

    @PutMapping("employees/add")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepoService.save(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeRepoService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found..." + employeeId);
        }
        employeeRepoService.deleteById(employeeId);
        return "Deleted employee with id " + employeeId;
    }
}
