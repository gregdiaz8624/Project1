package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Approval;
import com.revature.utils.JDBCConnection;

public class ApprovalRepoImpl implements ApprovalRepo {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public void updateApproval(Integer approvalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addApproval(Integer approvalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Approval getApprovalByStatus(Integer statusId) {
		String sql = "select * from approvals where status_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Approval a = new Approval();
				a.setApprovalId(rs.getInt("approval_id"));
				a.setApprovalStatus(rs.getString("approval_status"));
				a.setApprovalInfo(rs.getString("approval_info"));
				a.setApprovalNumber(rs.getInt("approval_number"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Approval getApproval(Integer approvalId) {
		// TODO Auto-generated method stub
		return null;
	}

}
