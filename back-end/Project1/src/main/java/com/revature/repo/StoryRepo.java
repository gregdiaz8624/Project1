package com.revature.repo;

import java.util.List;

import com.revature.models.Story;

public interface StoryRepo {
	
	void addStory(Story story, Integer id); // Throw story object as well as author id; 
	void updateStory(Integer id);
	
	List<Story> getStories(Integer id);
	Story getStoryById(Integer id);

}
