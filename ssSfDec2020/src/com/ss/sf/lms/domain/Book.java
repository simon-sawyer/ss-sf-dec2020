package com.ss.sf.lms.domain;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 436400080381931634L;
	private Integer bookId;
	private String title;
	private Integer authorId;
	private Integer pubId;
		
	public Book(Integer bookId, String title, Integer authorId, Integer pubId){
		this.bookId = bookId;
		this.title = title;
		this.authorId = authorId;
		this.pubId = pubId;
	}
	
	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public Book(){
		bookId = null;
		title = null;
		authorId = null;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorId=" + authorId + ", pubId=" + pubId + "]";
	}
	
}	
	