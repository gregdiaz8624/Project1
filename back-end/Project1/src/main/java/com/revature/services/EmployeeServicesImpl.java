package com.revature.services;

import java.util.List;


import com.revature.models.Employee;
import com.revature.models.Story;
import com.revature.repo.EmployeeRepo;
import com.revature.repo.EmployeeRepoImpl;

public class EmployeeServicesImpl implements EmployeeServices {

	private EmployeeRepo empRepo = new EmployeeRepoImpl();
	
	@Override
	public Employee getEmployee(String user, String pass) {
		
		return empRepo.getEmployee(user, pass);
	}

	@Override
	public Employee getEmployee(Integer id) {
		return empRepo.getEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee em) {
		empRepo.updateEmployee(em);
		return empRepo.getEmployee(em.getEmployeeId());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.getAllEmployees();
	}

	@Override
	public void addEmployeeToStory(Story st) {

		Employee ali = getEmployee(1);
		Employee berry = getEmployee(4);
		Employee mister = getEmployee(8);			
		
		ali.setStory1(st);
		berry.setStory2(st);
		mister.setStory3(st);
		
		updateEmployee(ali);
		updateEmployee(berry);
		updateEmployee(mister);
	}

}
