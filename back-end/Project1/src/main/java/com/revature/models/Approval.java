package com.revature.models;

public class Approval {
	
	private Integer approvalId;
	private String approvalStatus;
	private String approvalInfo;
	private Integer approvalNumber;
	
	public Approval() {
		super();
		
	}

	public Approval(Integer approvalId, String approvalStatus, String approvalInfo, Integer approvalNumber) {
		super();
		this.approvalId = approvalId;
		this.approvalStatus = approvalStatus;
		this.approvalInfo = approvalInfo;
		this.approvalNumber = approvalNumber;
	}

	public Integer getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalInfo() {
		return approvalInfo;
	}

	public void setApprovalInfo(String approvalInfo) {
		this.approvalInfo = approvalInfo;
	}

	public Integer getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(Integer approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvalId == null) ? 0 : approvalId.hashCode());
		result = prime * result + ((approvalInfo == null) ? 0 : approvalInfo.hashCode());
		result = prime * result + ((approvalNumber == null) ? 0 : approvalNumber.hashCode());
		result = prime * result + ((approvalStatus == null) ? 0 : approvalStatus.hashCode());
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
		Approval other = (Approval) obj;
		if (approvalId == null) {
			if (other.approvalId != null)
				return false;
		} else if (!approvalId.equals(other.approvalId))
			return false;
		if (approvalInfo == null) {
			if (other.approvalInfo != null)
				return false;
		} else if (!approvalInfo.equals(other.approvalInfo))
			return false;
		if (approvalNumber == null) {
			if (other.approvalNumber != null)
				return false;
		} else if (!approvalNumber.equals(other.approvalNumber))
			return false;
		if (approvalStatus == null) {
			if (other.approvalStatus != null)
				return false;
		} else if (!approvalStatus.equals(other.approvalStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", approvalStatus=" + approvalStatus + ", approvalInfo="
				+ approvalInfo + ", approvalNumber=" + approvalNumber + "]";
	}
	
	

	
}
