package com.revature.services;

import com.revature.models.Author;
import com.revature.repo.AuthorRepo;
import com.revature.repo.AuthorRepoImpl;


public class AuthorServicesImpl implements AuthorServices {
	private AuthorRepo authRepo = new AuthorRepoImpl();

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

		return authRepo.getAuthor(user, pass);
	
	}

	@Override
	public Author getAuthor(Integer id) {
		
		// TODO Auto-generated method stub
		return authRepo.getAuthor(id);
	}

}
