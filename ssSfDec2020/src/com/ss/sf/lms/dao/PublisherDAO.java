package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.Publisher;

public class PublisherDAO extends BaseDAO {

	public void addPublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_publisher Values (?, ?, ?, ?)", 
				new Object[] {publisher.getPubId(), publisher.getPubName(), publisher.getPubAddress(), publisher.getPubPhone()});
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("Update tbl_publisher Set publisherName = ?, publisherAddress = ?, publisherPhone = ? Where publisherId = ?", 
				new Object[] {publisher.getPubName(), publisher.getPubAddress(), publisher.getPubPhone(), publisher.getPubId()});
	}
	
	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_publisher Where publisherId = ?",
				new Object[] {publisher.getPubId()});
	}
	
	public Publisher getPublisher(int pubId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_publisher Where publisherId = ?");
		pstmt.setInt(1,  pubId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Publisher(rs.getInt("publisherId"), rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone"));
		}else{
			return null;
		}
	}
	
	public List<Publisher> readPublisher() throws ClassNotFoundException, SQLException{
		List<Publisher> publisherList = new ArrayList<Publisher>();
		pstmt = getConnection().prepareStatement("Select * From tbl_publisher");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			publisherList.add(new Publisher(rs.getInt("publisherId"), rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone")));	
		}
		return publisherList;
	}
	
	public List<Publisher> readPublisherByName(String name) throws ClassNotFoundException, SQLException{
		List<Publisher> publisherList = new ArrayList<Publisher>();
		pstmt = getConnection().prepareStatement("Select * From tbl_publisher Where publisherName = ?");
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			publisherList.add(new Publisher(rs.getInt("publisherId"), rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone")));	
		}
		return publisherList;
	}
	
	public List<Publisher> readPublisherByAddress(String address) throws ClassNotFoundException, SQLException{
		List<Publisher> publisherList = new ArrayList<Publisher>();
		pstmt = getConnection().prepareStatement("Select * From tbl_publisher Where publisherAddress = ?");
		pstmt.setString(1, address);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			publisherList.add(new Publisher(rs.getInt("publisherId"), rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone")));	
		}
		return publisherList;
	}
	
	public List<Publisher> readPublisherByPhone(String phone) throws ClassNotFoundException, SQLException{
		List<Publisher> publisherList = new ArrayList<Publisher>();
		pstmt = getConnection().prepareStatement("Select * From tbl_publisher Where publisherPhone = ?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			publisherList.add(new Publisher(rs.getInt("publisherId"), rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone")));	
		}
		return publisherList;
	}
}
