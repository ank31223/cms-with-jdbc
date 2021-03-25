package com.infoobjects.cmslm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.infoobjects.cmslm.dto.Employee;
import com.infoobjects.cmslm.utils.CommonGenearteUUID;

public class EmployeeDAO {
	Connection con;
	PreparedStatement pst;

	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	public void saveEmployee(Employee employee) {
		/*
		 * try { String
		 * query="insert into Employee values('"+CommonGenearteUUID.generateId()+"','"+
		 * employee.getName()+"','"+employee.getAge()+"','"+employee.getContactNo()+
		 * "','"+employee.getEmail()+"')"; Statement st=con.createStatement();
		 * System.out.println(st.executeUpdate(query));
		 * 
		 * System.out.println("inserted successfully"); }catch(SQLException e) {
		 * System.out.println("the error is "+e); }
		 */
		try {
			String query = "insert into Employee values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, CommonGenearteUUID.generateId());
			pst.setString(2, employee.getName());
			pst.setInt(3, employee.getAge());
			pst.setInt(4, employee.getContactNo());
			pst.setString(5, employee.getEmail());
			int rs = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void removeEmployee(String x) {
		/*
		 * try { String query="delete from Employee where employeeName='"+x+"'";
		 * Statement st=con.createStatement(); st.executeUpdate(query);
		 * }catch(SQLException e) { System.out.println("the remove error is "+ e); }
		 */
		try {
			String sqlStatement = " delete from Employee where employeeName=?";
			PreparedStatement pstmt = con.prepareStatement(sqlStatement);
			pstmt.setString(1, x);
			pstmt.executeUpdate();
			System.out.println("employee deleted Successfully");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Employee getEmployeeById(String name) {
		Employee emp = new Employee();
		try {
			String str = "select * from Employee where employeeName=?";
			PreparedStatement pst = con.prepareStatement(str);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			rs.next();
			emp.setId(rs.getString(1));
			emp.setName(rs.getString(2));
			emp.setAge(rs.getInt(3));
			emp.setContactNo(rs.getInt(4));
			emp.setEmail(rs.getString(5));
		} catch (SQLException e) {
			System.out.println(e);
		}
		return emp;
	}

	public void updateEmployee(Employee emp, String name, int age, int contactNo, String email) {
		/*
		 * try { String
		 * query="update Employee set employeeName='"+name+"',employeeAge='"+age+
		 * "',employeeContactNo='"+contactNo+"',employeeEmail='"+
		 * email+"' where employeeName='"+emp.getName()+"'"; Statement
		 * st=con.createStatement(); st.executeUpdate(query); }catch(SQLException e) {
		 * System.out.println("the update error is "+e); }
		 */
		try {
			String str = "update Employee set employeeName=?,employeeAge=?,employeeContactNo=?,employeeEmail=? where employeeName=?";
			PreparedStatement pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setInt(3, contactNo);
			pst.setString(4, email);
			pst.setString(5, emp.getName());
			System.out.println(pst.executeUpdate());
			System.out.println("Employee has been updated successfully");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public List<Employee> getEmployeeList() {
		/*
		 * List<Employee> list = new ArrayList(); String query =
		 * "select * from Employee"; try { PreparedStatement
		 * pst=con.prepareStatement(query); ResultSet rs=pst.executeQuery();
		 * while(rs.next()) { Employee emp = new Employee(); String name =
		 * rs.getString("employeeName"); int age = rs.getInt(3); int contactNo =
		 * rs.getInt(4); String email = rs.getString(5); String ids = rs.getString(1);
		 * 
		 * emp.setAge(age); emp.setContactNo(contactNo); emp.setEmail(email);
		 * emp.setName(name); emp.setId(ids); list.add(emp); } }catch(SQLException e) {
		 * System.out.println("the retrieve error is "+ e);
		 * 
		 * } return list;
		 */
		List<Employee> list = new ArrayList();
		String query = "select * from Employee";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Employee emp = new Employee();
				String name = rs.getString("employeeName");
				int age = rs.getInt(3);
				int contactNo = rs.getInt(4);
				String email = rs.getString(5);
				String ids = rs.getString(1);
				emp.setAge(age);
				emp.setContactNo(contactNo);
				emp.setEmail(email);
				emp.setName(name);
				emp.setId(ids);
				list.add(emp);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

}
