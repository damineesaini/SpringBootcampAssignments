package com.rest.RestfulWebService1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // Ques 3  to get list of employees.
    @GetMapping()
    public ArrayList<Employee> retrieveAllEmployees(){
        return employeeService.findAll();
    }

    // Ques 4 using path variable to get one employee
    @GetMapping("/{id}")
    public Employee retrieveEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {
        Employee employee = employeeService.findOneById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("Incorrect id");
        return employee;
    }

    // Ques 5  to create a new employee.
    @PostMapping()
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) throws EmployeeIdExistException {
        Employee newEmployee = employeeService.createNewEmployee(employee);
        if(newEmployee == null)
            throw new EmployeeIdExistException("Id already exist, don't define an id.");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Ques 7 to delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
        Employee employee = employeeService.deleteById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("Incorrect id");
    }

    //Ques 8 to update employee
    @PutMapping()
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        Employee employee1 = employeeService.updateEmployeeDetails(employee);
            if (employee1 == null)
                throw new EmployeeNotFoundException("Incorrect id");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
