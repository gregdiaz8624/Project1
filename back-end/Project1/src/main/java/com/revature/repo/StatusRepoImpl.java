package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Status;
import com.revature.utils.JDBCConnection;

public class StatusRepoImpl implements StatusRepo{
	
	private Connection conn = JDBCConnection.getConnection();
	private ApprovalRepo approvalRepo = new ApprovalRepoImpl();

	@Override
	public void updateStatus(Integer statusId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStatus(Integer storyId) {
		// TODO Auto-generated method stub
		
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
				
				s.setApproval(approvalRepo.getApprovalByStatus(s.getStatusId()));

				return s;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Status getStatus(Integer statusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
