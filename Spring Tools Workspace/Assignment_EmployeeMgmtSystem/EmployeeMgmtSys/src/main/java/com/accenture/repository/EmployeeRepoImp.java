package com.accenture.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accenture.connection.GetConnection;
import com.accenture.employee.Employee;
import com.accenture.employee.EmployeeMapper;

@Component
public class EmployeeRepoImp implements EmployeeRepo {
	
	@Autowired
	GetConnection con;
	
	private JdbcTemplate jdbctemplate;

	@Override
	public void info() {
		jdbctemplate = con.getTemplateObject();
		System.out.println("-----Connection Object ------ "+jdbctemplate);
	}
	
	// declare sql queries 
	private final String SQL_SEARCH_EMPLOYEE = "select * from employee where eid=?";
	private final String SQL_GET_ALL_EMPLOYEE = "select * from employee";
	private final String SQL_INSERT_NEW_EMPLOYEE = "insert into employee (eid, efirstname, elastname, esalary, eaddress) values(?,?,?,?,?)";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set efirstname=?, elastname=?, esalary=?, eaddress=? where eid=?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employee where eid=?";

	@Override
	public String insert(Employee emp) {
		String status = "";
		System.out.println(emp);
		int value = jdbctemplate.update(SQL_INSERT_NEW_EMPLOYEE, emp.geteID(), emp.geteFNAME(), emp.geteLNAME(), emp.geteSAL(), emp.geteADDR());
		if (value==1) {
			status = "-----New employee details added successfully-----";
		} else {
			status = "-----Insertion of details failed-----";
		}
		return status;
	}

	@Override
	public String update(Employee emp) {
		String status = "";
		System.out.println(emp);
		int value = jdbctemplate.update(SQL_UPDATE_EMPLOYEE,  emp.geteFNAME(), emp.geteLNAME(), emp.geteSAL(), emp.geteADDR(),emp.geteID());
		if (value==1) {
			status = "-----Employee details updated successfully-----";
		} else {
			status = "-----Update failed-----";
		}
		return status;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee search(String eID) {
		return jdbctemplate.queryForObject(SQL_SEARCH_EMPLOYEE, new Object[] {eID}, new EmployeeMapper());
	}

	@Override
	public List<Employee> viewAll() {
		List<Employee> empList = jdbctemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeMapper());
		return empList;
	}


	@Override
	public String delete(String eID) {
		String status="";
		int value = jdbctemplate.update(SQL_DELETE_EMPLOYEE, eID);
		if (value==1) {
			status = "-----Employee deleted-----";
		} else {
			status = "-----Deletion failed-----";
		}
		return status;
	}

}
