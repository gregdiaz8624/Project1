package com.revature.utils;

import org.junit.Test;

import com.revature.services.AuthorServices;
import com.revature.services.AuthorServicesImpl;



public class JunitTest {
	
	private AuthorServices auths = new AuthorServicesImpl();
	
	@Test
	public void test() {
		
		
		System.out.println(auths.getAuthor("greg", "1234"));
	}

}
