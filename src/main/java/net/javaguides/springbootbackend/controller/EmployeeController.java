package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // get all employee REST API
    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    //get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long Id,@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,Id),HttpStatus.OK);
    }

    //delete employee REST API
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long Id){
        employeeService.deleteEmployee(Id);
    }


}
