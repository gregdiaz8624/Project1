package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Story;
import com.revature.utils.JDBCConnection;

public class StoryRepoImpl implements StoryRepo {
	
	private Connection conn = JDBCConnection.getConnection();
	private StatusRepo statusRepo = new StatusRepoImpl();
	
	@Override
	public void addStory(Story story, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStory(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Story> getStories(Integer id) {
		List<Story> stories = new ArrayList<Story>();
		String sql = "SELECT * FROM stories s LEFT JOIN genres g ON s.genre_id = g.genre_id LEFT JOIN weights w ON w.weight_id = s.weight_id WHERE s.author_id = ?;";
		
		
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Story s = new Story();
				s.setStoryId(rs.getInt("story_id"));
				s.setTitle(rs.getString("title"));
				s.setTagline(rs.getString("tagline"));
				s.setDescription(rs.getString("description"));
				s.setCompletionDate(rs.getString("completion_date"));
				s.setGenre(rs.getString("genre"));
				s.setWeight(rs.getString("weight"));
				
				s.setStatus(statusRepo.getStatusByStory(s.getStoryId()));
				
				stories.add(s);
			}
			return stories;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Story getStoryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
