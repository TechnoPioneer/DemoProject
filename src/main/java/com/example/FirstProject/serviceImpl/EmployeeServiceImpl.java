package com.example.FirstProject.serviceImpl;

import com.example.FirstProject.model.Employee;
import com.example.FirstProject.repository.EmployeeRepository;
import com.example.FirstProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getTopEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<Employee> topEmployees = employees.stream().filter(employee -> employee.getSalary() > 50000).collect(Collectors.toList());
        return topEmployees;

    }
}
