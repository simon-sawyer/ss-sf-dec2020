package com.ss.sf.lms.domain;

import java.io.Serializable;

public class BookCopies implements Serializable{

	private static final long serialVersionUID = -2109734685690975014L;
	private Integer bookId;
	private Integer branchId;
	private Integer noOfCopies;
	
	public BookCopies(Integer bookId, Integer branchId, Integer numOfCopies) {
		this.bookId = bookId;
		this.branchId = branchId;
		this.noOfCopies = numOfCopies;
	}
	
	public BookCopies(){
		bookId = null;
		branchId = null;
		noOfCopies = null;
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer numOfCopies) {
		this.noOfCopies = numOfCopies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
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
		BookCopies other = (BookCopies) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookCopies [bookId=" + bookId + ", branchId=" + branchId + ", noOfCopies=" + noOfCopies + "]";
	}
	
}
