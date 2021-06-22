package com.revature.models;

public class Employee {
	
	private Integer employeeId;
	private String employeeUsername;
	private String employeePassword;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeType;
	private String genre1;
	private String genre2;
	private String genre3;
	private Story story1;
	private Story story2;
	private Story story3;
	
	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeUsername, String employeePassword, String employeeFirstName,
			String employeeLastName, String employeeType, String genre1, String genre2, String genre3, Story story1,
			Story story2, Story story3) {
		super();
		this.employeeId = employeeId;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeType = employeeType;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.genre3 = genre3;
		this.story1 = story1;
		this.story2 = story2;
		this.story3 = story3;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

	public Story getStory1() {
		return story1;
	}

	public void setStory1(Story story1) {
		this.story1 = story1;
	}

	public Story getStory2() {
		return story2;
	}

	public void setStory2(Story story2) {
		this.story2 = story2;
	}

	public Story getStory3() {
		return story3;
	}

	public void setStory3(Story story3) {
		this.story3 = story3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeFirstName == null) ? 0 : employeeFirstName.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeLastName == null) ? 0 : employeeLastName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeType == null) ? 0 : employeeType.hashCode());
		result = prime * result + ((employeeUsername == null) ? 0 : employeeUsername.hashCode());
		result = prime * result + ((genre1 == null) ? 0 : genre1.hashCode());
		result = prime * result + ((genre2 == null) ? 0 : genre2.hashCode());
		result = prime * result + ((genre3 == null) ? 0 : genre3.hashCode());
		result = prime * result + ((story1 == null) ? 0 : story1.hashCode());
		result = prime * result + ((story2 == null) ? 0 : story2.hashCode());
		result = prime * result + ((story3 == null) ? 0 : story3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeFirstName == null) {
			if (other.employeeFirstName != null)
				return false;
		} else if (!employeeFirstName.equals(other.employeeFirstName))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeLastName == null) {
			if (other.employeeLastName != null)
				return false;
		} else if (!employeeLastName.equals(other.employeeLastName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeType == null) {
			if (other.employeeType != null)
				return false;
		} else if (!employeeType.equals(other.employeeType))
			return false;
		if (employeeUsername == null) {
			if (other.employeeUsername != null)
				return false;
		} else if (!employeeUsername.equals(other.employeeUsername))
			return false;
		if (genre1 == null) {
			if (other.genre1 != null)
				return false;
		} else if (!genre1.equals(other.genre1))
			return false;
		if (genre2 == null) {
			if (other.genre2 != null)
				return false;
		} else if (!genre2.equals(other.genre2))
			return false;
		if (genre3 == null) {
			if (other.genre3 != null)
				return false;
		} else if (!genre3.equals(other.genre3))
			return false;
		if (story1 == null) {
			if (other.story1 != null)
				return false;
		} else if (!story1.equals(other.story1))
			return false;
		if (story2 == null) {
			if (other.story2 != null)
				return false;
		} else if (!story2.equals(other.story2))
			return false;
		if (story3 == null) {
			if (other.story3 != null)
				return false;
		} else if (!story3.equals(other.story3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeType=" + employeeType + ", genre1=" + genre1 + ", genre2=" + genre2
				+ ", genre3=" + genre3 + ", story1=" + story1 + ", story2=" + story2 + ", story3=" + story3 + "]";
	}
	
	
	
}
