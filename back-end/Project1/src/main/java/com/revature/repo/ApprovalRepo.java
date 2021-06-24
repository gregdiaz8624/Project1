package com.revature.repo;

import com.revature.models.Approval;

public interface ApprovalRepo {
	
	void updateApproval(Approval a);
	void addApproval(Approval a, Integer statusId);
	
	Approval getApprovalByStatus(Integer statusId);
	Approval getApproval(Integer approvalId);

}
