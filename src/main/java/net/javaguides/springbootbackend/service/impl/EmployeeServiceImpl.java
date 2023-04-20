package net.javaguides.springbootbackend.service.impl;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import net.javaguides.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long Id) {
        Optional<Employee> employee= employeeRepository.findById(Id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee","Id","Id",Id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long Id) {
        //check if employee by that id exist or not
        Employee existingEmployee=employeeRepository.findById(Id).orElseThrow( ()-> new ResourceNotFoundException("Employee","Id","Id",Id) );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long Id) {
        employeeRepository.findById(Id).orElseThrow( ()-> new ResourceNotFoundException("Employee","Id","Id",Id));
        employeeRepository.deleteById(Id);
        return;
    }
}
