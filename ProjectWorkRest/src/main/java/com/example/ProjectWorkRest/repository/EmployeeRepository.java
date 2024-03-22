package com.example.ProjectWorkRest.repository;

import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee getEmployeeById(String employeeID) throws NotFoundException {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        throw new NotFoundException(String.format("No employee found with ID: %s", employeeID));
    }

    public ResponseEntity<List<Employee>> getAllEmployees() throws NotFoundException {
        if (employees.isEmpty()) {
            throw new NotFoundException(String.format("No employee has been found"));
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEmployeeById(String employeeId) {
        if (employees.removeIf(x -> x.getEmployeeID().equals(employeeId))) {
            return new ResponseEntity<>("Employee with ID " + employeeId + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with ID " + employeeId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        try {
            Employee createdEmployee = new Employee();

            createdEmployee.setCompany(employee.getCompany());
            createdEmployee.setName(employee.getName());
            createdEmployee.setEmployeeID(employee.getEmployeeID());
            createdEmployee.setLastName(employee.getLastName());

            employees.add(createdEmployee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateEmployee(String employeeId, Employee employee) {
        Employee employeeToUpdate = new Employee();
        for (Employee employeeCheck : employees) {
            if (employeeCheck.getEmployeeID().equals(employeeId)) {
                employeeToUpdate = employeeCheck;
                break;
            }
        }
        if (employeeToUpdate != null) {
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setName(employee.getName());
            employeeToUpdate.setEmployeeID(employee.getEmployeeID());
            employeeToUpdate.setCompany(employee.getCompany());

            employees.remove(employeeToUpdate);
            employees.add(employee);

            return new ResponseEntity<>("Employee with ID " + employeeId + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with ID " + employeeId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    public List<Employee> save(List<Employee> employeesList) {
        employees.addAll(employeesList);
        return employeesList;
    }
}
