package com.revature.repo;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Status;
import com.revature.utils.JDBCConnection;

public class StatusRepoImpl implements StatusRepo{
	
	
	private Connection conn = JDBCConnection.getConnection();
	private ApprovalRepo appRepo = new ApprovalRepoImpl();

	@Override
	public Status addStatus(Status st, Integer storyId) {
		String sql = "insert into statuses values (DEFAULT, ?, ?, ?, ?, ?, ?, ?) returning *;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getStatus());
			ps.setBoolean(2, st.isPriority());
			ps.setString(3, st.getStatusDate());
			ps.setString(4, st.getAssistantInfo());
			ps.setString(5, st.getAuthorInfo());
			ps.setString(6, st.getGeneralInfo());
			ps.setString(7, st.getSeniorInfo());

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Status s = new Status();
				s.setStatusId(rs.getInt("status_id"));
				return s;
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Status getStatusByStory(Integer storyId) {
		String sql = "SELECT * FROM stories LEFT JOIN statuses ON stories.status_id = statuses.status_id WHERE stories.status_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Status s = new Status();
				s.setStatusId(rs.getInt("status_id"));
				s.setStatus(rs.getString("status"));
				s.setPriority(rs.getBoolean("priority"));
				s.setStatusDate(rs.getString("status_date"));
				s.setAssistantInfo(rs.getString("assistant_info"));
				s.setAuthorInfo(rs.getString("author_info"));
				s.setGeneralInfo(rs.getString("general_info"));
				s.setSeniorInfo(rs.getString("senior_info"));
				
				s.setApproval(appRepo.getApprovalByStatus(s.getStatusId()));

				return s;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Status getStatus(Integer statusId) {
		String sql = "SELECT * FROM statuses where status_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Status s = new Status();
				s.setStatusId(rs.getInt("status_id"));
				s.setStatus(rs.getString("status"));
				s.setPriority(rs.getBoolean("priority"));
				s.setStatusDate(rs.getString("status_date"));
				s.setAssistantInfo(rs.getString("assistant_info"));
				s.setAuthorInfo(rs.getString("author_info"));
				s.setGeneralInfo(rs.getString("general_info"));
				s.setSeniorInfo(rs.getString("senior_info"));
				
				s.setApproval(appRepo.getApprovalByStatus(s.getStatusId()));

				return s;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void updateStatus(Status st) {
		String sql = "Update statuses set status = ?, priority = ?, status_date = ?, assistant_info = ?, author_info = ?, general_info = ?, senior_info = ? where status_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getStatus());
			ps.setBoolean(1, st.isPriority());
			ps.setString(1, st.getStatusDate());
			ps.setString(1, st.getAssistantInfo());
			ps.setString(1, st.getAuthorInfo());
			ps.setString(1, st.getGeneralInfo());
			ps.setString(1, st.getSeniorInfo());
			ps.setInt(1, st.getStatusId());

			ps.executeUpdate();
			appRepo.updateApproval(st.getApproval());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
