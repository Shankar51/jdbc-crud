package com.shan.service;

import java.math.BigDecimal;
import java.util.List;

import com.shan.dto.Employee;

public interface EmployeeService {
	
	List getEmployees();	
	Employee getEmployee(int empId);
	boolean insertEmployee(int id,String name,String address,String role,BigDecimal salary);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(int empId);
	
}
