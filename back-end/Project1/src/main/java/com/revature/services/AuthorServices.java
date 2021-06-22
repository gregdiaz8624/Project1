package com.revature.services;

import com.revature.models.Author;

public interface AuthorServices {
	
	void addAuthor(Author a);
	void updateAuthor(Integer id);
	
	Author getAuthor(String user, String pass);
	Author getAuthor(Integer id);
}
