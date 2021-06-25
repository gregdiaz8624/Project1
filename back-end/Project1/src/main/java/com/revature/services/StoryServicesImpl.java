package com.revature.services;

import java.util.List;

import com.revature.models.Story;
import com.revature.repo.StoryRepo;
import com.revature.repo.StoryRepoImpl;

public class StoryServicesImpl implements StoryServices {

	private StoryRepo stoRepo = new StoryRepoImpl();

	@Override
	public List<Story> getStories(Integer authorId) {
		System.out.println("Services called");
		return stoRepo.getStories(authorId);
	}

	@Override
	public Story getStory(Integer storyId) {
		return stoRepo.getStoryById(storyId);

	}

	@Override
	public Story updateStory(Story story) {
		stoRepo.updateStory(story);
		return stoRepo.getStoryById(story.getStoryId());
	}

	@Override
	public Story addStory(Story story, Integer authorId) {
		return stoRepo.addStory(story, authorId);

	}

	

}
