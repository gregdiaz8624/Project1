package com.revature.services;

import com.revature.models.Status;

public interface StatusServices {
	
	Status updateStatus(Status sta);
	Status getStatusByStory(Integer storyId);
	Status getStatus(Integer statusId);

}
