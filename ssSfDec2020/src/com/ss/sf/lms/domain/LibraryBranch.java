package com.ss.sf.lms.domain;

import java.io.Serializable;

public class LibraryBranch implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7248563750777289416L;
	private Integer branchId;
	private String branchName;
	private String branchAddress;
	
	public LibraryBranch(Integer branchId, String branchName, String branchAddress) {
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}
	
	public LibraryBranch(){
		branchId = null;
		branchName = null;
		branchAddress = null;
	}
	
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branchId;
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
		LibraryBranch other = (LibraryBranch) obj;
		if (branchId != other.branchId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibraryBranch [branchId=" + branchId + ", branchName=" + branchName + ", branchAddress=" + branchAddress
				+ "]";
	}
	
}
