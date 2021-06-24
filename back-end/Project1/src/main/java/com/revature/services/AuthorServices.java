package com.revature.services;

import com.revature.models.Author;

public interface AuthorServices {
	

	Author updateAuthor(Author auth);
	
	Author getAuthor(String user, String pass);
	Author getAuthor(Integer id);
}
