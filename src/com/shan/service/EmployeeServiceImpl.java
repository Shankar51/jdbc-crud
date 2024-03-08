package com.shan.service;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shan.connector.ConnectorFactory;
import com.shan.dto.Employee;
import com.shan.exception.InvalidAddressLengthException;
import com.shan.exception.InvalidSalaryException;


public class EmployeeServiceImpl implements EmployeeService {
	ArrayList<Employee> emplist = null;

	@Override
	public List<Employee> getEmployees() {
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select*from employees";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			emplist = new ArrayList<Employee>();

			while (res.next() == true) {
				int empId = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String role = res.getString(4);
				BigDecimal salary = res.getBigDecimal(5);

				Employee e1 = new Employee(empId, name, address, role, salary);
				emplist.add(e1);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplist;

	}

	@Override
	public Employee getEmployee(int empId) {
		Employee e2 = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select*from employees where empId =?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			e2 = new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
					res.getBigDecimal(5));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return e2;
	}

	@Override
	public boolean insertEmployee(int empId, String name, String address, String role, BigDecimal salary){
		try {
			if (salary.compareTo(new BigDecimal("25000")) < 0 || salary.compareTo(new BigDecimal("50000")) > 0) {
				throw new InvalidSalaryException("Invalid salary. Salary must be between 25000 and 50000.");
			}
			if(address.length()>45) {
				throw new InvalidAddressLengthException("Address length cannot exceed 45 characters.");
			}
			Connection con = ConnectorFactory.requestConnection();
			String query = "insert into employees(`empId`,`name`,`address`,`role`,`salary`) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empId);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, role);

			pstmt.setBigDecimal(5, salary);

			pstmt.executeUpdate();

		}catch(InvalidAddressLengthException e) {
			System.out.println(e.getMesg());
		}
		catch(InvalidSalaryException e) {
			System.out.println(e.getMesg());
		}
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("try with different id");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		try {
			
	    if (e.getSalary().compareTo(new BigDecimal("25000")) < 0
	            || e.getSalary().compareTo(new BigDecimal("50000")) > 0) {
	        throw new InvalidSalaryException("Invalid salary. Salary must be between 25000 and 50000.");
	    }
		if(e.getAddress().length()>45) {
			throw new InvalidAddressLengthException("Address length cannot exceed 45 characters.");
		}

			Connection con = ConnectorFactory.requestConnection();
			String query = "update employees set salary=?,name=?,address=?,role=? where empId=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setBigDecimal(1, e.getSalary());
			pstmt.setString(2, e.getName());
			
			pstmt.setString(3, e.getAddress());
			
			pstmt.setString(4, e.getRole());
			pstmt.setInt(5, e.getEmpId());

			pstmt.executeUpdate();

		}catch(InvalidAddressLengthException f) {
			System.out.println(f.getMesg());
		}
		catch(InvalidSalaryException f) {
			System.out.println(f.getMesg());
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "delete from employees where empId=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empId);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}


