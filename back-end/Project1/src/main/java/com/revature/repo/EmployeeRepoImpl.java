package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.JDBCConnection;

public class EmployeeRepoImpl implements EmployeeRepo {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public void updateEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(String user, String pass) {
		
		String sql = "select * from employees where employee_username = ? and employee_password = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				
				
				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		
		return null;
	}

	@Override
	public List<String> getGenres(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
