package com.ss.sf.lms.domain;

import java.io.Serializable;

public class Publisher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9035255114982091340L;
	private Integer pubId;
	private String pubName;
	private String pubAddress;
	private String pubPhone;
	
	public Publisher(Integer pubId, String pubName, String pubAddress, String pubPhone) {
		this.pubId = pubId;
		this.pubName = pubName;
		this.pubAddress = pubAddress;
		this.pubPhone = pubPhone;
	}

	public Publisher() {
		pubId = null;
		pubName = null;
		pubAddress = null;
		pubPhone = null;
	}

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getPubAddress() {
		return pubAddress;
	}

	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}

	public String getPubPhone() {
		return pubPhone;
	}

	public void setPubPhone(String pubPhone) {
		this.pubPhone = pubPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pubId == null) ? 0 : pubId.hashCode());
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
		Publisher other = (Publisher) obj;
		if (pubId == null) {
			if (other.pubId != null)
				return false;
		} else if (!pubId.equals(other.pubId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [pubId=" + pubId + ", pubName=" + pubName + ", pubAddress=" + pubAddress + ", pubPhone="
				+ pubPhone + "]";
	}
		
}
