package com.ss.sf.lms.domain;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 4417405850051697497L;
	private Integer authorId;
	private String authorName;
	
	public Author(Integer authorId, String authorName){
		this.authorId = authorId;
		this.authorName = authorName;
	}
	
	public Author(){
		authorId = null;
		authorName = null;
	}
	
	public Integer getAuthorId(){
		return authorId;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	
	public void setAuthorId(Integer authorId){
		this.authorId = authorId;
	}
	
	public void setAuthorName(String authorName){
		this.authorName = authorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
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
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Author Id: " + authorId + ", Author Name: " + authorName;
	}
	
}
