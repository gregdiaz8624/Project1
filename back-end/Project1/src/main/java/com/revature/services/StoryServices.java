package com.revature.services;

import java.util.List;

import com.revature.models.Story;

public interface StoryServices {
	
	List<Story> getStories (Integer authorId); 
	Story getStory (Integer storyId);
	
	void updateStory(Integer storyId);
	void addStory(Story story, Integer authorId);

}
