package com.infoobjects.cmslm.bootstrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.infoobjects.cmslm.controller.EmployeeController;
import com.infoobjects.cmslm.controller.EmployeeControllerImpl;
import com.infoobjects.cmslm.dao.EmployeeDAO;
import com.infoobjects.cmslm.service.EmployeeService;
import com.infoobjects.cmslm.service.EmployeeServiceImpl;

/**
 * 
 * @author ankit
 *
 */
public class CMSLMBootstrap {
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Connection con;

		try {
			String url = "jdbc:mysql://localhost:3306/cms";
			String uname = "ank31223";
			String upass = "ank31223";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upass);
			Statement st = con.createStatement();
			String query = "create table if not exists Employee(employeeId varchar(60) not null primary key,employeeName varchar(40) not null,employeeAge int not null,employeeContactNo int not null,employeeEmail varchar(60) not null)";
			st.executeUpdate(query);
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);
			EmployeeController employeeController = new EmployeeControllerImpl(scanner, employeeService);

			while (true) {
				System.out.print(
						"\n the choices\n 1.add\n 2.delete\n 3.update\n 4.showAllEmployees \n 5.showEmployeeById\n 6.exit=-1");
				System.out.print("\n Enter the choice\n");
				int choice = scanner.nextInt();
				if (choice == -1) {
					break;
				}

				switch (choice) {
				case 1:
					try {
						employeeController.addEmployee();
					} catch (Exception e) {
						System.out.print("the error is " + e);
					}
					break;
				case 2:
					employeeController.removeEmployee();
					break;
				case 3:
					employeeController.updateEmployee();
					break;
				case 4:
					employeeController.showAllEmployee();
					break;
				case 5:
					break;
				default:
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
