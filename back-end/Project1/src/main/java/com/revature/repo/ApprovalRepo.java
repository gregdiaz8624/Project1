package com.revature.repo;

import com.revature.models.Approval;

public interface ApprovalRepo {
	
	void updateApproval(Integer approvalId);
	void addApproval(Integer approvalId);
	
	Approval getApprovalByStatus(Integer statusId);
	Approval getApproval(Integer approvalId);

}
