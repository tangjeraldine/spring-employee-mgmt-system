package com.accenture.repository;

import java.util.List;

import com.accenture.employee.Employee;

public interface EmployeeRepo {

	void info();
	String insert(Employee emp);
	String update(Employee emp);
	Employee search(String eID);
	List<Employee> viewAll();
	String delete(String eID);
}
