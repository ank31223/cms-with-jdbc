package com.infoobjects.cmslm.service;

import java.util.List;

import com.infoobjects.cmslm.dto.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void removeEmployee(String x);

	Employee getEmployeeById(String nextInt);

	List<Employee> getEmployeeList();

	void updateEmployee(Employee emp, String name, int age, int contactNo, String email);


}
