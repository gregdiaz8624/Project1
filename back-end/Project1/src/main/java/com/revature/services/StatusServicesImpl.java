package com.revature.services;

import com.revature.models.Status;
import com.revature.repo.StatusRepo;
import com.revature.repo.StatusRepoImpl;

public class StatusServicesImpl implements StatusServices {
	private StatusRepo staRepo = new StatusRepoImpl();
	
	@Override
	public Status updateStatus(Status sta) {
		staRepo.updateStatus(sta);
		return staRepo.getStatus(sta.getStatusId());
	}

	@Override
	public Status getStatusByStory(Integer storyId) {
		return staRepo.getStatusByStory(storyId);
	}

	@Override
	public Status getStatus(Integer statusId) {
		return staRepo.getStatus(statusId);
	}

}
