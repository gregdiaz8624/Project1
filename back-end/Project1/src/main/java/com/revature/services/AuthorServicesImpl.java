package com.revature.services;

import com.revature.models.Author;
import com.revature.repo.AuthorRepo;
import com.revature.repo.AuthorRepoImpl;


public class AuthorServicesImpl implements AuthorServices {
	private AuthorRepo authRepo = new AuthorRepoImpl();



	@Override
	public Author getAuthor(String user, String pass) {
		return authRepo.getAuthor(user, pass);
	
	}

	@Override
	public Author getAuthor(Integer id) {
		return authRepo.getAuthor(id);
	}

	@Override
	public Author updateAuthor(Author auth) {
		authRepo.updateAuthorPoints(auth);
		return authRepo.getAuthor(auth.getAuthorId());
	}

}
