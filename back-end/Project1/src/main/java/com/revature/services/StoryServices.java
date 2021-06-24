package com.revature.services;

import java.util.List;


import com.revature.models.Story;

public interface StoryServices {
	
	List<Story> getStories (Integer authorId); 
	Story getStory (Integer storyId);
	
	Story updateStory(Story story);
	Story addStory(Story story, Integer authorId);

}
