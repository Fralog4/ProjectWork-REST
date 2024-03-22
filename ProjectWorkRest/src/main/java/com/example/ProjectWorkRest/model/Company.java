package com.example.ProjectWorkRest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company{
    private String companyId;
    private List<Employee> employeeCompanyList;
    private String address;
    private String name;
}
