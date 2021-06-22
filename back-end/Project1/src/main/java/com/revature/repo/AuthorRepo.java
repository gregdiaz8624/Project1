package com.revature.repo;

import com.revature.models.Author;

public interface AuthorRepo {
	
	void addAuthor(Author a);
	void updateAuthor(Integer id);
	
	Author getAuthor(String user, String pass);
	Author getAuthor(Integer id);

}
