package com.example.ProjectWorkRest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Employee {
	private String employeeID;
	private String name;
	private String lastName;
	private Company company;
}
