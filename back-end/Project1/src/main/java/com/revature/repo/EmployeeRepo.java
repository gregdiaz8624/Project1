package com.revature.repo;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeRepo {
	
	void updateEmployee(Integer employeeId);
	
	Employee getEmployee(String user, String pass);
	Employee getEmployee(Integer employeeId);
	List<String> getGenres(Integer employeeId);
	
}
