package com.infoobjects.cmslm.dto;

public class Employee {
	private String id;
    private String name;
    private int age;
    private int contactNo;
    private String email;
    
    public Employee() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public Employee(String id, String name, int age, int contactNo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.email = email;
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Employee Detaills:- "+id+" "+name+"  "+age+" "+contactNo+" "+email;
}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getContactNo() {
		return contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
