package com.shan.dto;

import java.math.BigDecimal;

public class Employee {

	private int empId;
    private String name;
    private String address;
    private String role;
    private BigDecimal salary;
    
	public Employee(int empId, String name, String address, String role, BigDecimal salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.role = role;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String toString() {
		return this.empId+" "+this.name+" "+this.address+" "+this.role+" "+this.salary;
	}
	
}
