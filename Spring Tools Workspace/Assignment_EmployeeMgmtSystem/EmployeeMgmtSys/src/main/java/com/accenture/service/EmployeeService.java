package com.accenture.service;

import java.util.List;

import com.accenture.employee.Employee;

public interface EmployeeService {

	void info();
	
	String addEmployee(Employee emp);
	String updateEmployee(Employee emp);
	Employee searchEmployee(String eID);
	List<Employee> searchAllEmployees();
	String deleteEmployee(String eID);
}
