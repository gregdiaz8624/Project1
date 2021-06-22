package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Author;
import com.revature.utils.JDBCConnection;

public class AuthorRepoImpl implements AuthorRepo {
	
	private Connection conn = JDBCConnection.getConnection();
	private StoryRepo storyRepo = new StoryRepoImpl();

	@Override
	public void addAuthor(Author a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuthor(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author getAuthor(String user, String pass) {
		String sql = "select * from authors where author_username = ? and author_password = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Author a = new Author();
				a.setAuthorId(rs.getInt("author_id"));
				a.setAuthorUsername(user);
				a.setAuthorPassword(pass);
				a.setAuthorFirstName(rs.getString("author_first_name"));
				a.setAuthorLastName(rs.getString("author_last_name"));
				a.setAuthorPoints(rs.getInt("author_points"));
				a.setStories(storyRepo.getStories(a.getAuthorId()));
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Author getAuthor(Integer id) {
		String sql = "select * from authors where author_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Author a = new Author();
				a.setAuthorId(rs.getInt("author_id"));
				a.setAuthorUsername(rs.getString("author_username"));
				a.setAuthorPassword(rs.getString("author_password"));
				a.setAuthorFirstName(rs.getString("author_first_name"));
				a.setAuthorLastName(rs.getString("author_last_name"));
				a.setAuthorPoints(rs.getInt("author_points"));

				a.setStories(storyRepo.getStories(a.getAuthorId()));
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
