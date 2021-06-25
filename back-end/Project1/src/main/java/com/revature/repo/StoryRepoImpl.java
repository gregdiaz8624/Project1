package com.revature.repo;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.revature.models.Approval;
import com.revature.models.Status;
import com.revature.models.Story;
import com.revature.utils.JDBCConnection;

public class StoryRepoImpl implements StoryRepo {
	
	private Connection conn = JDBCConnection.getConnection();
	private StatusRepo statRepo = new StatusRepoImpl();
//	private ApprovalRepo appRepo = new ApprovalRepoImpl();

	
	@Override
	public Story getStoryById(Integer id) {
		String sql = "SELECT * FROM stories s LEFT JOIN genres g ON s.genre_id = g.genre_id LEFT JOIN weights w ON w.weight_id = s.weight_id WHERE s.story_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Story s = new Story();
				s.setStoryId(rs.getInt("story_id"));
				s.setTitle(rs.getString("title"));
				s.setTagline(rs.getString("tagline"));
				s.setDescription(rs.getString("description"));
				s.setCompletionDate(rs.getString("completion_date"));
				s.setGenre(rs.getString("genre"));
				s.setWeight(rs.getString("weight"));

				s.setStatus(statRepo.getStatusByStory(s.getStoryId()));

				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
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
				System.out.println(s.getStoryId());
				s.setStatus(statRepo.getStatusByStory(s.getStoryId()));
				System.out.println("this is story 1" + s);
				stories.add(s);
			}
			return stories;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Story addStory(Story story, Integer id) {
		String sql = "insert into stories values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		String sGen = story.getGenre();
		String sWei = story.getWeight();
		Status stat = story.getStatus();
//		Approval aApp = stat.getApproval();

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, story.getTitle());
			ps.setString(2, story.getTagline());
			ps.setString(3, story.getDescription());
			ps.setString(4, story.getCompletionDate());
			ps.setInt(5, id);

			// -----------Genre----------

			if (sGen.equals("Murder Mystery")) {
				ps.setInt(6, 1);
			}
			if (sGen.equals("Fiction")) {
				ps.setInt(6, 2);
			}
			if (sGen.equals("Self Help")) {
				ps.setInt(6, 3);
			}
			if (sGen.equals("Travel")) {
				ps.setInt(6, 4);
			}
			if (sGen.equals("History")) {
				ps.setInt(6, 5);
			}
			if (sGen.equals("Autobiography")) {
				ps.setInt(6, 6);
			}

			// -------------Weight--------------

			if (sWei.equals("Novel")) {
				ps.setInt(7, 1);
			}
			if (sWei.equals("Novella")) {
				ps.setInt(7, 2);
			}
			if (sWei.equals("Short Story")) {
				ps.setInt(7, 3);
			}
			if (sWei.equals("Article")) {
				ps.setInt(7, 4);
			}

			ps.setInt(8, 1);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer aStoryId = rs.getInt("story_id");
				System.out.println(aStoryId);
				Status statId = statRepo.addStatus(stat, aStoryId);
				Integer astatId = statId.getStatusId();
				updateStoryStatus(astatId, aStoryId);
				return getStoryById(aStoryId);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateStory(Story story) {
		String sql = "update stories set title = ?, tagline = ?, description = ?, completion_date = ?;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, story.getTitle());
			ps.setString(2, story.getTagline());
			ps.setString(3, story.getDescription());
			ps.setString(4, story.getCompletionDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateStoryStatus(Integer statid, Integer storyid) {
		String sql = "update stories set status_id = ? where story_id = ?;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statid);
			ps.setInt(2, storyid);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
