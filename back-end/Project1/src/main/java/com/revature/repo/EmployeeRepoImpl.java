package com.revature.repo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.JDBCConnection;

public class EmployeeRepoImpl implements EmployeeRepo {
	
	private Connection conn = JDBCConnection.getConnection();
	private StoryRepo stDao = new StoryRepoImpl();

	@Override
	public void updateEmployee(Employee e ) {
		String sql = "update employees set employee_story1 = ?, employee_story2 = ?, employee_story3 = ? where employee_id = ?;";
		Integer st1id = 0;
		Integer st2id = 0;
		Integer st3id = 0;

		try {
			st1id = e.getStory1().getStoryId();
			if (e.getStory2().getStoryId() != null) {
				st2id = e.getStory2().getStoryId();
			} else {
				st2id = 0;
			}
			
			if (e.getStory3().getStoryId() != null) {
				st3id = e.getStory3().getStoryId();
			} else {
				st3id = 0;
			}
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, st1id);
			
			if (st2id != null && st2id != 0) {
				ps.setInt(2, st2id);
			} else {
				ps.setInt(2, 0);
			}
			
			if (st3id != null && st3id != 0) {
				ps.setInt(3, st3id);
			} else {
				ps.setInt(3, 0);
			}
	
			ps.setInt(4, e.getEmployeeId());

			ps.executeUpdate();

		} catch (NullPointerException | SQLException exc) {
			exc.printStackTrace();
		}

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
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setEmployeeUsername(user);
				e.setEmployeePassword(pass);
				e.setEmployeeFirstName(rs.getString("employee_first_name"));
				e.setEmployeeLastName(rs.getString("employee_last_name"));
				e.setEmployeeType(rs.getString("employee_type"));
				
				Integer st1id = rs.getInt("employee_story1");
				Integer st2id = rs.getInt("employee_story2");
				Integer st3id = rs.getInt("employee_story3");

				if (st1id != null && st1id != 0) {
					e.setStory1(stDao.getStoryById(st1id));
				}
				
				if (st2id != null && st2id != 0) {
					e.setStory2(stDao.getStoryById(st2id));
				}
				
				if (st3id != null && st3id != 0) {
					e.setStory3(stDao.getStoryById(st3id));
				}
				
				if (rs.getInt("employee_genre1") == 1) {
					e.setGenre1("Murder Mystery");
				} else {
					e.setGenre1("Fiction");
				}
				
				if (rs.getInt("employee_genre2") == 2) {
					e.setGenre2("Self Help");
				} else {
					e.setGenre2("Travel");
				}
				
				if (rs.getInt("employee_genre3") == 3) {
					e.setGenre3("History");
				} else {
					e.setGenre3("Article");
				}
				
				
				
				return e;
			}

		} catch (SQLException | NullPointerException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		String sql = "select * from employees where employee_id = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(employeeId);
				e.setEmployeeUsername(rs.getString("employee_username"));
				e.setEmployeePassword(rs.getString("employee_username"));
				e.setEmployeeFirstName(rs.getString("employee_first_name"));
				e.setEmployeeLastName(rs.getString("employee_last_name"));
				e.setEmployeeType(rs.getString("employee_type"));
				
				Integer st1id = rs.getInt("employee_story1");
				Integer st2id = rs.getInt("employee_story2");
				Integer st3id = rs.getInt("employee_story3");

				if (st1id != null && st1id != 0) {
					e.setStory1(stDao.getStoryById(st1id));
				}
				
				if (st2id != null && st2id != 0) {
					e.setStory2(stDao.getStoryById(st2id));
				}
				
				if (st3id != null && st3id != 0) {
					e.setStory3(stDao.getStoryById(st3id));
				}
				
				if (rs.getInt("employee_genre1") == 1) {
					e.setGenre1("Murder Mystery");
				} else {
					e.setGenre1("Fiction");
				}
				
				if (rs.getInt("employee_genre2") == 2) {
					e.setGenre2("Self Help");
				} else {
					e.setGenre2("Travel");
				}
				
				if (rs.getInt("employee_genre3") == 3) {
					e.setGenre3("History");
				} else {
					e.setGenre3("Autobiography");
				}
				
				
				
				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getGenres(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employees;";

		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setEmployeeUsername(rs.getString("employee_username"));
				e.setEmployeePassword(rs.getString("employee_password"));
				e.setEmployeeFirstName(rs.getString("employee_first_name"));
				e.setEmployeeLastName(rs.getString("employee_last_name"));
				e.setEmployeeType(rs.getString("employee_type"));
				
				Integer st1id = rs.getInt("employee_story1");
				Integer st2id = rs.getInt("employee_story2");
				Integer st3id = rs.getInt("employee_story3");

				if (st1id != null && st1id != 0) {
					e.setStory1(stDao.getStoryById(st1id));
				}
				
				if (st2id != null && st2id != 0) {
					e.setStory2(stDao.getStoryById(st2id));
				}
				
				if (st3id != null && st3id != 0) {
					e.setStory3(stDao.getStoryById(st3id));
				}
				
				if (rs.getInt("employee_genre1") == 1) {
					e.setGenre1("Murder Mystery");
				} else {
					e.setGenre1("Fiction");
				}
				
				if (rs.getInt("employee_genre2") == 2) {
					e.setGenre2("Self Help");
				} else {
					e.setGenre2("Travel");
				}
				
				if (rs.getInt("employee_genre3") == 3) {
					e.setGenre3("History");
				} else {
					e.setGenre3("Autobiography");
				}
				
				employees.add(e);
			}
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return null;
	}

}
