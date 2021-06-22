package com.revature.models;

public class Status {
	
	private Integer statusId;
	private String status;
	private boolean priority;
	private String statusDate;
	private String assistantInfo;
	private String authorInfo;
	private String generalInfo;
	private String seniorInfo;
	private Approval approval;
	
	public Status() {
		super();
	}

	public Status(Integer statusId, String status, boolean priority, String statusDate, String assistantInfo,
			String authorInfo, String generalInfo, String seniorInfo, Approval approval) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.priority = priority;
		this.statusDate = statusDate;
		this.assistantInfo = assistantInfo;
		this.authorInfo = authorInfo;
		this.generalInfo = generalInfo;
		this.seniorInfo = seniorInfo;
		this.approval = approval;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getAssistantInfo() {
		return assistantInfo;
	}

	public void setAssistantInfo(String assistantInfo) {
		this.assistantInfo = assistantInfo;
	}

	public String getAuthorInfo() {
		return authorInfo;
	}

	public void setAuthorInfo(String authorInfo) {
		this.authorInfo = authorInfo;
	}

	public String getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}

	public String getSeniorInfo() {
		return seniorInfo;
	}

	public void setSeniorInfo(String seniorInfo) {
		this.seniorInfo = seniorInfo;
	}

	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((assistantInfo == null) ? 0 : assistantInfo.hashCode());
		result = prime * result + ((authorInfo == null) ? 0 : authorInfo.hashCode());
		result = prime * result + ((generalInfo == null) ? 0 : generalInfo.hashCode());
		result = prime * result + (priority ? 1231 : 1237);
		result = prime * result + ((seniorInfo == null) ? 0 : seniorInfo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
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
		Status other = (Status) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (assistantInfo == null) {
			if (other.assistantInfo != null)
				return false;
		} else if (!assistantInfo.equals(other.assistantInfo))
			return false;
		if (authorInfo == null) {
			if (other.authorInfo != null)
				return false;
		} else if (!authorInfo.equals(other.authorInfo))
			return false;
		if (generalInfo == null) {
			if (other.generalInfo != null)
				return false;
		} else if (!generalInfo.equals(other.generalInfo))
			return false;
		if (priority != other.priority)
			return false;
		if (seniorInfo == null) {
			if (other.seniorInfo != null)
				return false;
		} else if (!seniorInfo.equals(other.seniorInfo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + ", priority=" + priority + ", statusDate="
				+ statusDate + ", assistantInfo=" + assistantInfo + ", authorInfo=" + authorInfo + ", generalInfo="
				+ generalInfo + ", seniorInfo=" + seniorInfo + ", approval=" + approval + "]";
	}

	
	
	
}
