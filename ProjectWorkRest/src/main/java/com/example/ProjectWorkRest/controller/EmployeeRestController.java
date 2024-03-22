package com.example.ProjectWorkRest.controller;



import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.model.Employee;
import com.example.ProjectWorkRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() throws NotFoundException{
        return employeeService.getAllEmployees();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId)throws NotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }
    @PutMapping("{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(employeeId, updatedEmployee);
    }


    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }
}
