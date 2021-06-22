package com.revature.services;

import com.revature.models.Status;

public interface StatusServices {
	
	void updateStatus(Integer statusId);
	void addStatus(Integer storyId);
	
	Status getStatusByStory(Integer storyId);
	Status getStatus(Integer statusId);

}
