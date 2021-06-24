package com.revature.repo;

import com.revature.models.Status;

public interface StatusRepo {
	
	void updateStatus(Status st);
	Status addStatus(Status st, Integer storyId);
	
	Status getStatusByStory(Integer storyId);
	Status getStatus(Integer statusId);

}
