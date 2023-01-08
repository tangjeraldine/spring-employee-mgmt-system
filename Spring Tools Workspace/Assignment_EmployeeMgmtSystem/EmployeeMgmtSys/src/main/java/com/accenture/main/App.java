package com.accenture.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.employee.Employee;
import com.accenture.service.EmployeeService;
import com.accenture.service.EmployeeServiceImp;

public class App {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean startService = true;

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		// main app is controller, takes input by bufferedreader and takes in method
		// from service layer
		EmployeeService EmpServ = (EmployeeServiceImp) context.getBean("service");

		// print message to check connection status
		EmpServ.info();

		Scanner scan = new Scanner(System.in);
		Employee emp = new Employee();

		System.out.println("=====Welcome to the Employee Management System=====");

		while (startService) {
			System.out.println("______________________________________________");
			System.out.println("Please select a service number below to begin:");
			System.out.println("______________________________________________");
			System.out.println("Enter (1) to add a new employee.");
			System.out.println("Enter (2) to search for an employee by ID number.");
			System.out.println("Enter (3) to view the full list of employees.");
			System.out.println("Enter (4) to update the details of an existing employee.");
			System.out.println("Enter (5) to delete an employee's details.");
			System.out.println("Enter (6) to quit.");
			System.out.println("______________________________________________");

			int serviceNumber = scan.nextInt();

			switch (serviceNumber) {
			case 1:
				System.out.println("Enter new employee ID no.:");
				emp.seteID(scan.next());
				System.out.println("Enter new employee first name:");
				emp.seteFNAME(scan.next());
				System.out.println("Enter new employee last name:");
				emp.seteLNAME(scan.next());
				System.out.println("Enter new employee salary:");
				try {
					emp.seteSAL(scan.nextInt());
				} catch (Exception e) {
					System.out.println("Input invalid.");
					break;
				}
				System.out.println("Enter new employee address:");
				try {
					emp.seteADDR(scan.next());
				} catch (Exception e) {
					System.out.println("Input invalid");
					break;
				}
				String result = EmpServ.addEmployee(emp);
				System.out.println("-----Result-----");
				System.out.println(result);
				System.out.println("______________________________________________");
				break;
			case 2:
				System.out.println("Enter the employee ID:");
				try {
					emp.seteID(scan.next());
				} catch (Exception e) {
					System.out.println("Input invalid.");
				}
				
				Employee empSearch = EmpServ.searchEmployee(emp.geteID());
				System.out.println("-----Result-----");
				if (empSearch == null) {
					System.out.println("Employee does not exist.");
				} else {
					System.out.println("*****");
					System.out.println(">> Employee ID: " + empSearch.geteID());
					System.out.println(">> Employee First Name: " + empSearch.geteFNAME());
					System.out.println(">> Employee Last Name: " + empSearch.geteLNAME());
					System.out.println(">> Employee Salary: " + empSearch.geteSAL());
					System.out.println(">> Employee Address: " + empSearch.geteADDR());
					System.out.println("*****");
				}
				System.out.println("______________________________________________");
				break;
			case 3:
				List<Employee> eObj = EmpServ.searchAllEmployees();
				System.out.println("-----Result-----");
				if (eObj == null) {
					System.out.println("There are no employees to display.");
				} else {
					for (Employee item : eObj) {
						System.out.println("*****");
						System.out.println(">> Employee ID: " + item.geteID());
						System.out.println(">> Employee First Name: " + item.geteFNAME());
						System.out.println(">> Employee Last Name: " + item.geteLNAME());
						System.out.println(">> Employee Salary: " + item.geteSAL());
						System.out.println(">> Employee Address: " + item.geteADDR());
						System.out.println("*****");
					}
				}
				System.out.println("______________________________________________");
				break;
			case 4:
				System.out.println("Enter employee ID no.:");
				emp.seteID(scan.next());
				Employee searchExisting;
				try {
					searchExisting = EmpServ.searchEmployee(emp.geteID());
				//error: empty result data access exception --> Issue resolved.
				} catch (Exception e) {
					System.out.println("Employee ID does not exist.");
					System.out.println("______________________________________________");
					break;
				}
				BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Previous Entry for First Name: " + searchExisting.geteFNAME());
				System.out.println("Enter updated employee first name:");
				String newFN;
				try {
					newFN = b.readLine();
					if (newFN.equals("")) {
						newFN = searchExisting.geteFNAME();
						emp.seteFNAME(newFN);
						System.out.println("First name not updated.");
					}
					emp.seteFNAME(newFN);
					System.out.println(newFN);
				} catch (Exception e1) {
					newFN = searchExisting.geteFNAME();
					emp.seteFNAME(newFN);
					System.out.println("First name not updated.");
				}
	
				System.out.println("Previous Entry for Last Name: " + searchExisting.geteLNAME());
				System.out.println("Enter updated employee last name:");
				String newLN;
				try {
					newLN = b.readLine();
					if (newLN.equals("")) {
						newLN = searchExisting.geteLNAME();
						emp.seteLNAME(newLN);
						System.out.println("Last name not updated.");
					}
					emp.seteLNAME(newLN);
					System.out.println(newLN);
					
				} catch (Exception e1) {
					newLN = searchExisting.geteLNAME();
					emp.seteLNAME(newLN);
					System.out.println("Last name not updated.");
				}
				
				System.out.println("Previous Entry for Salary: " + searchExisting.geteSAL());
				System.out.println("Enter updated employee salary:");
				String newSAL;
				int intSAL;
				try {
					newSAL = b.readLine();
					intSAL = Integer.parseInt(newSAL);
					emp.seteSAL(intSAL);
					System.out.println(intSAL);
				} catch (NumberFormatException e1) {
					intSAL = searchExisting.geteSAL();
					emp.seteSAL(intSAL);
					System.out.println("Salary not updated.");
				} catch (Exception e2) {
					System.out.println("Input value is invalid.");
					e2.printStackTrace();
					break;
				}

				System.out.println("Previous Entry for Address: " + searchExisting.geteADDR());
				System.out.println("Enter updated employee address:");
				String newADD;
				try {
					newADD = b.readLine();
					if (newADD.equals("")) {
						newADD = searchExisting.geteADDR();
						emp.seteADDR(newADD);
						System.out.println("Address not updated.");
					}
					emp.seteADDR(newADD);
					System.out.println(newADD);
				}catch (Exception e1) {
					newADD = searchExisting.geteADDR();
					emp.seteADDR(newADD);
					System.out.println("Address not updated.");
				}
				
				result = EmpServ.updateEmployee(emp);
				System.out.println("-----Result-----");
				System.out.println(result);
				System.out.println("______________________________________________");
				break;
			case 5:
				System.out.println("Enter employee ID no.:");
				emp.seteID(scan.next());
				Employee findExisting;
				try {
					findExisting = EmpServ.searchEmployee(emp.geteID());
				//error: empty result data access exception --> Issue resolved.
				} catch (Exception e) {
					System.out.println("Employee ID does not exist.");
					System.out.println("______________________________________________");
					break;
				}
				System.out.println("Are you sure you wish to delete details of employee " + findExisting.geteFNAME()+ " "+findExisting.geteLNAME() + "? (y/n)");
				String del = scan.next();
				if (del.equals("y")) {
					result = EmpServ.deleteEmployee(emp.geteID());
					System.out.println("-----Result-----");
					System.out.println(result);
				} else {
					System.out.println("Employee details not deleted.");
				}
				System.out.println("______________________________________________");
				break;
			case 6:
				System.out.println("Thank you for accessing the Employee Management System.");
				System.out.println("______________________________________________");
				startService = false;
				System.exit(0);
				break;
			default:
				System.out.println("The service selected is not available, please try again.");
				break;
			}
		}

	}
}
//iterate in main to display results
//for (Employee eObj: empList) {
//	System.out.println(eObj);
//}