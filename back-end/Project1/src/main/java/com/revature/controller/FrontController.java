package com.revature.controller;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.google.gson.JsonSyntaxException;
import com.revature.models.Approval;
import com.revature.models.Author;
import com.revature.models.Employee;
import com.revature.models.Status;
import com.revature.models.Story;
import com.revature.services.ApprovalServices;
import com.revature.services.ApprovalServicesImpl;
import com.revature.services.AuthorServices;
import com.revature.services.AuthorServicesImpl;
import com.revature.services.EmployeeServices;
import com.revature.services.EmployeeServicesImpl;
import com.revature.services.StatusServices;
import com.revature.services.StatusServicesImpl;
import com.revature.services.StoryServices;
import com.revature.services.StoryServicesImpl;

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
	
	class EmployeeCred {
		public String user;
		public String pass;

		public EmployeeCred(String user, String pass) {
			super();
			this.user = user;
			this.pass = pass;
		}

		@Override
		public String toString() {
			return "Employee [user=" + user + ", pass=" + pass + "]";
		}
	}
	
	class tempApp {
        public String approvalStatus;
        public Integer approvalNumber;
        public Integer statusId;
        
		public tempApp(String approvalStatus, Integer approvalNumber, Integer statusId) {
			super();
			this.approvalStatus = approvalStatus;
			this.approvalNumber = approvalNumber;
			this.statusId = statusId;
		}

		@Override
		public String toString() {
			return "tempApp [approvalStatus=" + approvalStatus + ", approvalNumber=" + approvalNumber + ", statusId="
					+ statusId + "]";
		}

        
	}
	
	private Gson gson = new Gson();
	public static HttpSession session;


	private ApprovalServices apps = new ApprovalServicesImpl();
	private AuthorServices auths = new AuthorServicesImpl();
	private EmployeeServices ems = new EmployeeServicesImpl();
	private StatusServices stas = new StatusServicesImpl();
	private StoryServices stos = new StoryServicesImpl();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, IllegalStateException, JsonSyntaxException {
		
//		AuthorCred testA = new AuthorCred("greg", "1234");

		String uri = request.getRequestURI();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		session = request.getSession();

		uri = uri.substring("/Project1/controller/".length());

		switch (uri) {
		
		case "authorpage": {
			System.out.println("Author Page loading");
			Author alogg = (Author) session.getAttribute("logged_in");

			Author loggedAuthor = auths.getAuthor(alogg.getAuthorId());

			response.getWriter().append(gson.toJson(loggedAuthor));
			System.out.println("Sent author object to front end");
			break;
		}
		
		case "employeepage": {
			Employee elogg = (Employee) session.getAttribute("logged_in");
			Employee loggedEmployee = ems.getEmployee(elogg.getEmployeeId());
			System.out.println(loggedEmployee);
			response.getWriter().append(gson.toJson(loggedEmployee));
			System.out.println("Sent employee object to front end");
			break;
		}
		
		case "allemployees": {
			response.getWriter().append(gson.toJson(ems.getAllEmployees()));
			System.out.println("Sending all the employees");
			break;
		}

		case "home": {
			response.getWriter().append("authorlogin.html");
			break;
		}
		
		case "logout": {
			
			System.out.println("Logging out");
			session.invalidate();
			response.getWriter().append("authorlogin.html");
			break;
		}

		default: {
			System.out.println("Reached the default case...");
			response.sendError(418, "No Good");
		}

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


		String uri = request.getRequestURI();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		session = request.getSession();

		uri = uri.substring("/Project1/controller/".length());
		
		switch (uri) {

		case "authorlogin": {
			System.out.println("Received author login!");
			System.out.println(request.getReader());
				AuthorCred ac = gson.fromJson(request.getReader(), AuthorCred.class);
				System.out.println(ac);
				Author a = auths.getAuthor(ac.user, ac.pass);
				if (a != null) {
					session.setAttribute("logged_in", a);
					response.getWriter().append("authorpage.html");
					System.out.println("Author logged in");
				} else {
					System.out.println("Failed to login");
				}
			break;
		}
		
		case "employeelogin": {
			EmployeeCred ec = gson.fromJson(request.getReader(), EmployeeCred.class);
			System.out.println(ec);
			Employee em = ems.getEmployee(ec.user, ec.pass);
			if (em != null) {
				session.setAttribute("logged_in", em);
				response.getWriter().append("employeepage.html");
				System.out.println("Employee logged in ");
			} else {
				System.out.println("Failed to login");
			}
			break;
		}
		
		case "addstory": {
			Story story = gson.fromJson(request.getReader(), Story.class);
			Author alogg = (Author) session.getAttribute("logged_in");
			System.out.println(story);
			Story addedStory = stos.addStory(story, alogg.getAuthorId());
			
			ems.addEmployeeToStory(addedStory);
			break;
		}
		
		case "updateauthor": {
			Author author = gson.fromJson(request.getReader(), Author.class);
			System.out.println(author);
			auths.updateAuthor(author);
			break;
		}
		
		case "updateemployee": {
			Employee emp = gson.fromJson(request.getReader(), Employee.class);
			System.out.println(emp);
			ems.updateEmployee(emp);
			break;
		}
		
		case "updatestory": {
			Story story = gson.fromJson(request.getReader(), Story.class);
			System.out.println(story);
			stos.updateStory(story);
			break;
		}
		
		case "updatestatus": {
			Status status = gson.fromJson(request.getReader(), Status.class);
			System.out.println(status);
			stas.updateStatus(status);
			break;
		}
		
		case "addapproval": {
            tempApp tApp = gson.fromJson(request.getReader(), tempApp.class);
            System.out.println(tApp + "hi");
            Approval zApp = new Approval();
            zApp.setApprovalStatus("committee");
            zApp.setApprovalNumber(1);
            apps.addApproval(zApp, tApp.statusId);
            break;
        }
		
		case "updateapproval": {
			Approval app = gson.fromJson(request.getReader(), Approval.class);
			System.out.println(app);
			apps.updateApproval(app);
			break;
		}
		
		default: {
			
			System.out.println("Reached the default case in post...");
			response.sendError(418, "NO GOOD");
		}
		
		
		
		
		}
		
	}

}