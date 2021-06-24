package com.revature.repo;

import com.revature.models.Author;

public interface AuthorRepo {
	
	void addAuthor(Author a);
	void updateAuthorPoints(Author a);
	
	Author getAuthor(String user, String pass);
	Author getAuthor(Integer id);

}
