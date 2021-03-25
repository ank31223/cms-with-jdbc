package com.infoobjects.cmslm.service;

import java.util.List;

import com.infoobjects.cmslm.dao.EmployeeDAO;
import com.infoobjects.cmslm.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Override
	public void removeEmployee(String x) {
		employeeDAO.removeEmployee(x);
	}

	public Employee getEmployeeById(String nextInt) {
		return employeeDAO.getEmployeeById(nextInt);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeDAO.getEmployeeList();
	}

	@Override
	public void updateEmployee(Employee emp, String name, int age, int contactNo, String email) {
		employeeDAO.updateEmployee(emp, name, age, contactNo, email);
	}

}
