package com.revature.services;

import com.revature.models.Approval;

public interface ApprovalServices {
	
	void updateApproval(Integer approvalId);
	void addApproval(Integer approvalId);
	
	Approval getApprovalByStatus(Integer statusId);
	Approval getApproval(Integer approvalId);

}
