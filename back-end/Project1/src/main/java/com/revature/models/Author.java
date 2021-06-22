package com.revature.models;

import java.util.List;

public class Author {
	
	private Integer authorId;
	private String authorUsername;
	private String authorPassword;
	private String authorFirstName;
	private String authorLastName;
	private Integer authorPoints; 
	private List<Story> stories;
	
	public Author() {
		super();
	}

	public Author(Integer authorId, String authorUsername, String authorPassword, String authorFirstName,
			String authorLastName, Integer authorPoints, List<Story> stories) {
		super();
		this.authorId = authorId;
		this.authorUsername = authorUsername;
		this.authorPassword = authorPassword;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorPoints = authorPoints;
		this.stories = stories;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public String getAuthorPassword() {
		return authorPassword;
	}

	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public Integer getAuthorPoints() {
		return authorPoints;
	}

	public void setAuthorPoints(Integer authorPoints) {
		this.authorPoints = authorPoints;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorFirstName == null) ? 0 : authorFirstName.hashCode());
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((authorLastName == null) ? 0 : authorLastName.hashCode());
		result = prime * result + ((authorPassword == null) ? 0 : authorPassword.hashCode());
		result = prime * result + ((authorPoints == null) ? 0 : authorPoints.hashCode());
		result = prime * result + ((authorUsername == null) ? 0 : authorUsername.hashCode());
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
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
		Author other = (Author) obj;
		if (authorFirstName == null) {
			if (other.authorFirstName != null)
				return false;
		} else if (!authorFirstName.equals(other.authorFirstName))
			return false;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (authorLastName == null) {
			if (other.authorLastName != null)
				return false;
		} else if (!authorLastName.equals(other.authorLastName))
			return false;
		if (authorPassword == null) {
			if (other.authorPassword != null)
				return false;
		} else if (!authorPassword.equals(other.authorPassword))
			return false;
		if (authorPoints == null) {
			if (other.authorPoints != null)
				return false;
		} else if (!authorPoints.equals(other.authorPoints))
			return false;
		if (authorUsername == null) {
			if (other.authorUsername != null)
				return false;
		} else if (!authorUsername.equals(other.authorUsername))
			return false;
		if (stories == null) {
			if (other.stories != null)
				return false;
		} else if (!stories.equals(other.stories))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", authorUsername=" + authorUsername + ", authorPassword="
				+ authorPassword + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName
				+ ", authorPoints=" + authorPoints + ", stories=" + stories + "]";
	}
	
	
	
	
	

}
