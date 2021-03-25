package com.infoobjects.cmslm.controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.infoobjects.cmslm.dto.Employee;
import com.infoobjects.cmslm.service.EmployeeService;

public class EmployeeControllerImpl implements EmployeeController {
	private Scanner scanner;
	private EmployeeService employeeService;

	public EmployeeControllerImpl(Scanner scanner, EmployeeService employeeService) {
		this.scanner = scanner;
		this.employeeService = employeeService;
	}

	@Override
	public void addEmployee() throws CapitalException {
		Employee employee = new Employee();
		System.out.println("Enter the Employee Detaills to be added:- ");
		System.out.println("Enter the Name of Employee");
		scanner.nextLine();
		String name = scanner.nextLine();
		if (isCapital(name)) {

		} else {
			throw new CapitalException("name must be in capital letters");
		}
		employee.setName(name);
		System.out.println("Enter the Age of Employee");
		employee.setAge(scanner.nextInt());
		System.out.println("Enter the contactNo of Employee");
		employee.setContactNo(scanner.nextInt());
		System.out.println("Enter the emailId of Employee");
		String email = scanner.next();
		String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		int i = 0;

		if (pattern.matcher(email).matches()) {
			employee.setEmail(email);
		} else {

			while (i != 3) {
				System.out.println("Enter the valid emailId of Employee");
				email = scanner.next();
				if (pattern.matcher(email).matches()) {
					employee.setEmail(email);
					break;
				}
				i++;
			}
		}
		if (i != 3) {
			employeeService.addEmployee(employee);
			System.out.print("User added Successfully");
		} else {
			System.out.print("User not able to add employee");
		}

	}

	@Override
	public void removeEmployee() {
		System.out.println("enter the name of employee  you want to delete");
		scanner.nextLine();
		String x = scanner.nextLine();
		employeeService.removeEmployee(x);
	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter the name of Employee whose details you want to update");
		scanner.nextLine();
		Employee emp = employeeService.getEmployeeById(scanner.nextLine());
		System.out.println(emp);
		System.out.println("Update employee name,age,contactNo and email");
		System.out.println("update name");
		String name = scanner.nextLine();
		System.out.println("update age");
		int age = scanner.nextInt();
		System.out.println("update contact no");
		int contactNo = scanner.nextInt();
		System.out.println("update email");
		String email = scanner.next();
		employeeService.updateEmployee(emp, name, age, contactNo, email);
	}

	@Override
	public void showAllEmployee() {
		for (Employee empl : employeeService.getEmployeeList()) {
			System.out.println(empl);
		}
	}

	private boolean isCapital(String name) {
		char[] arr = name.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isLowerCase(arr[i])) {
				return false;
			}
		}
		return true;
	}

}
