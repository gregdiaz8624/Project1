package com.revature.services;

import java.util.List;


import com.revature.models.Employee;
import com.revature.models.Story;

public interface EmployeeServices {
	
	Employee getEmployee(String user, String pass);
	Employee getEmployee(Integer id);
	
	void addEmployeeToStory(Story st);
	
	Employee updateEmployee(Employee em);
	List<Employee> getAllEmployees();

}
