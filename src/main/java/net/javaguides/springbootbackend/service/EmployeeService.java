package net.javaguides.springbootbackend.service;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;

import java.util.*;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long Id);
    Employee updateEmployee(Employee employee,long Id);
    void deleteEmployee(long Id);
}