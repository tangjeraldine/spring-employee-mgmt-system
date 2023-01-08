package com.accenture.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements org.springframework.jdbc.core.RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int i) throws SQLException {
		Employee emp = new Employee();
		emp.seteID(rs.getString("eid"));
		emp.seteFNAME(rs.getString("efirstname"));
		emp.seteLNAME(rs.getString("elastname"));
		emp.seteSAL(rs.getInt("esalary"));
		emp.seteADDR(rs.getString("eaddress"));
		
		return emp;
	}
}
