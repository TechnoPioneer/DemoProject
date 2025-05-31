package com.example.FirstProject.controller;

import com.example.FirstProject.model.Employee;
import com.example.FirstProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/topEmployees")
     public List<Employee> getTopEmployees() {

        List<Employee> employees = employeeService.getTopEmployees();
        return employees;
    }
}
