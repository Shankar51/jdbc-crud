package jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.shan.dao.EmployeeDAOImpl;
import com.shan.dto.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeDAOImpl empdaoimp = new EmployeeDAOImpl();
			Scanner scan = new Scanner(System.in);
			int option=0;
			do {
				System.out.println("select 1 for retrive all employee data");
				System.out.println("select 2 for retrive data by empId ");
				System.out.println("select 3 for update salary by empid");
				System.out.println("select 4 for insert new employee ");
				System.out.println("select 5 to delete employee by id");
				System.out.println("select 6 to exit");
				
				option = scan.nextInt();
				
			 switch(option) {
				 case 1: 
			 
				List<Employee> employees = empdaoimp.getEmployees();		
				for(Object e:employees) {
				System.out.println(e);	
				}
				break;
			
				 case 2:
					System.out.println("enter the employee id you want see details");
					int empId = scan.nextInt();
					Employee em= empdaoimp.getEmployee(empId);
					System.out.println(em);
					break;

			
				 case 3:
					
					System.out.println("enter the employee id you want to update");
					int empId1 = scan.nextInt();
					Employee em1= empdaoimp.getEmployee(empId1);
					System.out.println(em1);
					 
					
										 
					System.out.println("press 1 to update salary");
					System.out.println("press 2 for name update");
					System.out.println("press 3 for address update");
					System.out.println("press 4 for role update");
					int option2 = scan.nextInt();
					switch(option2) {
					case 1:
						System.out.println("Enter the salary to be updated: ");
						BigDecimal newSalary = scan.nextBigDecimal();
						em1.setSalary(newSalary);
						empdaoimp.updateEmployee(em1);					
						System.out.println("salary of employee whose employeeId is"+" "+empId1+" has updated");
						break;
					
					case 2:
						System.out.println("enter the name to be updated");
						String name = scan.next();
						em1.setName(name);
						empdaoimp.updateEmployee(em1);
						System.out.println("name of employee whose employeeId is"+" "+empId1+" has updated");
						break;
					
					case 3:
						System.out.println("enter the name to be updated");
						String address = scan.next();
						em1.setAddress(address);
						empdaoimp.updateEmployee(em1);
						System.out.println("address of employee whose employeeId is"+" "+empId1+" has updated");
						break;
					
					case 4:
						System.out.println("enter the name to be updated");
						String roll = scan.next();
						em1.setRole(roll);
						empdaoimp.updateEmployee(em1);
						System.out.println("rll of employee whose employeeId is"+" "+empId1+" has updated");
						break;
					 }
					break;

		
				 case 5:
					 System.out.println("Enter the Employee Id to delete");
					 int emp = scan.nextInt();
					 empdaoimp.deleteEmployee(emp);
					 System.out.println("Employee whose Employee id "+emp+" has been deleted from dataBase");
					 break;
			 		
				
				 case 4:
					System.out.println("Enter the Employee data to be insert");
					System.out.println("Enter the EmpId");
					int empId2 = scan.nextInt();
					
					System.out.println("Enter the name of Employee");
					String name = scan.next();
					
					System.out.println("Enter the address of Employee");
					String address = scan.next();
					
					System.out.println("Enter the role of Employee");
					String role = scan.next();
					
					System.out.println("Enter the salary of Employee");
					BigDecimal salary=scan.nextBigDecimal();				
					empdaoimp.insertEmployee(empId2, name, address, role, salary);
					
					
					
					System.out.println("Here is the updated dataBase==========");
					List<Employee> employees1 = empdaoimp.getEmployees();		
					for(Object e:employees1) {
					System.out.println(e);
					}
					break;
				 case 6:	
		
					System.exit(0);					 			 			
			}
			 System.out.println();
			 }while(option!=6);



			

	}

}
