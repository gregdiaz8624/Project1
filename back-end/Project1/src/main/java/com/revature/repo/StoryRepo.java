package com.revature.repo;

import java.util.List;

import com.revature.models.Story;

public interface StoryRepo {
	
	Story getStoryById(Integer id);
	List<Story> getStories(Integer id);
	Story addStory(Story story, Integer id);
	void updateStory(Story story);
	void updateStoryStatus(Integer statid, Integer storyid);
	
}
