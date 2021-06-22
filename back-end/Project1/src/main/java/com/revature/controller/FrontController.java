package com.revature.controller;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Author;
import com.revature.models.Story;
import com.revature.services.AuthorServices;
import com.revature.services.AuthorServicesImpl;

public class FrontController extends HttpServlet {

	class AuthorCred {
		public String user;
		public String pass;
		
		public AuthorCred(String user, String pass) {
			super();
			this.user = user;
			this.pass = pass;
		}

		@Override
		public String toString() {
			return "AuthorCred [user=" + user + ", pass=" + pass + "]";
		}

	}

	private AuthorServices auths = new AuthorServicesImpl();
	private Gson gson = new Gson();
	public static HttpSession session;
	public JsonParser json = new JsonParser();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, IllegalStateException, JsonSyntaxException {
//		GsonBuilder gb = new GsonBuilder();
//		this.gson = gb.create();
		
		AuthorCred testA = new AuthorCred("greg", "1234");

		String uri = request.getRequestURI();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		session = request.getSession();

		uri = uri.substring("/Project1/controller/".length());

		switch (uri) {
		
		case "AuthorPage": {
			System.out.println("Author Page loading");
			Author alogg = (Author) session.getAttribute("logged_in");
			Author loggedAuthor = auths.getAuthor(alogg.getAuthorId());
			System.out.println(loggedAuthor);
			response.getWriter().append(gson.toJson(loggedAuthor));
			System.out.println("Sent author object to front end");
		}
		
		

		case "home": {
			response.getWriter().append("AuthorLogin.html");
			break;
		}

		default: {
			System.out.println("Reached the default case...");
			response.sendError(418, "BRB MAKING TEA");
		}

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AuthorCred testA = new AuthorCred("greg", "1234");

		String uri = request.getRequestURI();
		String json = gson.toJson(testA);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		session = request.getSession();

		uri = uri.substring("/Project1/controller/".length());
		
		switch (uri) {

		case "AuthorLogin": {
			System.out.println("Received author login!");
			System.out.println(request.getReader());
				AuthorCred ac = gson.fromJson(request.getReader(), AuthorCred.class);			
				Author a = auths.getAuthor(ac.user, ac.pass);
				if (a != null) {
					session.setAttribute("logged_in", a);
					response.getWriter().append("AuthorPage.html");
					System.out.println("Author log in g00d");
				} else {
					System.out.println("Failed to login");
				}
			break;
		}
		}
		
	}

}