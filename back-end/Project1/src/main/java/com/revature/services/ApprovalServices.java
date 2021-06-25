package com.revature.services;

import com.revature.models.Approval;

public interface ApprovalServices {
	
	Approval updateApproval(Approval app);
	Approval getApprovalByStatus(Integer statusId);
	Approval getApproval(Integer approvalId);
	void addApproval(Approval zApp, Integer status_id);

}
