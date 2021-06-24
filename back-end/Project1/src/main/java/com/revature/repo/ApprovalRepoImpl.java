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
	public void updateApproval(Approval a) {
		String sql = "update approvals set approval_status = ?, approval_info= ?, approval_number = ? where approval_id = ?;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getApprovalStatus());
			ps.setString(2, a.getApprovalInfo());
			ps.setInt(3, a.getApprovalNumber());
			ps.setInt(4, a.getApprovalId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addApproval(Approval a, Integer statusId) {
		String sql = "insert into approvals values (DEFAULT, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getApprovalStatus());
			ps.setString(2, a.getApprovalInfo());
			if (a.getApprovalNumber() != null) {
				ps.setInt(3, a.getApprovalNumber());
			} else {
				ps.setInt(3, 0);
			}
			ps.setInt(4, statusId);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		String sql = "select * from approvals where approval_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, approvalId);

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
	
}
