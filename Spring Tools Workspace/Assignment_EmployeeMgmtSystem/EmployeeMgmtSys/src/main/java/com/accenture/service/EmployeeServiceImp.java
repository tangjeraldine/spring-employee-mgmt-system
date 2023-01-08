package com.accenture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.employee.Employee;
import com.accenture.repository.EmployeeRepo;

@Component("service")
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepo empDAO;
	
	// add try/catch and throw exception --> !!!!CHECK

	@Override
	public void info() {
		System.out.println("-----Service Object Created-----");
		empDAO.info();
	}

	@Override
	public String addEmployee(Employee emp) {
		return empDAO.insert(emp);
	}

	@Override
	public String updateEmployee(Employee emp) {
		return empDAO.update(emp);
	}

	@Override
	public Employee searchEmployee(String eID) {
		return empDAO.search(eID);
	}

	@Override
	public List<Employee> searchAllEmployees() {
		return empDAO.viewAll();
	}

	@Override
	public String deleteEmployee(String eID) {
		return empDAO.delete(eID);
	}

}
