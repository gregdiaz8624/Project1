package com.revature.services;

import com.revature.models.Approval;
import com.revature.repo.ApprovalRepo;
import com.revature.repo.ApprovalRepoImpl;

public class ApprovalServicesImpl implements ApprovalServices {
	private ApprovalRepo appRepo = new ApprovalRepoImpl();
	
	@Override
	public Approval updateApproval(Approval app) {
		appRepo.updateApproval(app);
		return appRepo.getApproval(app.getApprovalId());
		
	}

	@Override
	public Approval getApprovalByStatus(Integer statusId) {
		return appRepo.getApprovalByStatus(statusId);
	}

	@Override
	public Approval getApproval(Integer approvalId) {
		return appRepo.getApproval(approvalId);
	}

	@Override
	public void addApproval(Approval zApp, Integer status_id) {
		appRepo.addApproval(zApp, status_id);
	}

}
