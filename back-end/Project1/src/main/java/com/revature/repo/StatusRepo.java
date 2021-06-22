package com.revature.repo;

import com.revature.models.Status;

public interface StatusRepo {
	
	void updateStatus(Integer statusId);
	void addStatus(Integer storyId);
	
	Status getStatusByStory(Integer storyId);
	Status getStatus(Integer statusId);

}
