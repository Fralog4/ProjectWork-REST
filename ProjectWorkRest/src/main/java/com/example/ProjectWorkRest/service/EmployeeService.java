package com.example.ProjectWorkRest.service;

import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.model.Employee;
import com.example.ProjectWorkRest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(String employeeId)throws NotFoundException {
        return employeeRepository.getEmployeeById(employeeId);
    }
    public ResponseEntity<List<Employee>> getAllEmployees() throws NotFoundException{
        return employeeRepository.getAllEmployees();
    }

    public ResponseEntity<String> deleteEmployeeById(String employeeId) {
        return employeeRepository.deleteEmployeeById(employeeId);
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }
    public ResponseEntity<String> updateEmployee(String employeeId, Employee employee) {
        return employeeRepository.updateEmployee(employeeId,employee);
    }

    public List<Employee> save(List<Employee> employeesList) {
        return employeeRepository.save(employeesList);
    }
}
