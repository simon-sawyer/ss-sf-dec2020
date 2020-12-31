package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.Borrower;

public class BorrowerDAO extends BaseDAO {

	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_borrower Values (?, ?, ?, ?)", 
				new Object[] {borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone()});
	}
	
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("Update tbl_borrower Set name = ?, address = ?, phone = ? Where cardNo = ?", 
				new Object[] {borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo()});
	}
	
	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_borrower Where cardNo = ?",
				new Object[] {borrower.getCardNo()});
	}
	public Borrower getBorrower(int cardNo) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_borrower Where cardNo = ?");
		pstmt.setInt(1,  cardNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
		}else{
			return null;
		}
	}
	
	public List<Borrower> readBorrower() throws ClassNotFoundException, SQLException{
		List<Borrower> borrowerList = new ArrayList<Borrower>();
		pstmt = getConnection().prepareStatement("Select * From tbl_borrower");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			borrowerList.add(new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")));	
		}
		return borrowerList;
	}
	
	public List<Borrower> readBorrowerByName(String name) throws ClassNotFoundException, SQLException{
		List<Borrower> borrowerList = new ArrayList<Borrower>();
		pstmt = getConnection().prepareStatement("Select * From tbl_borrower Where name = ?");
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			borrowerList.add(new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")));	
		}
		return borrowerList;
	}
	
	public List<Borrower> readBorrowerByAddress(String address) throws ClassNotFoundException, SQLException{
		List<Borrower> borrowerList = new ArrayList<Borrower>();
		pstmt = getConnection().prepareStatement("Select * From tbl_borrower Where address = ?");
		pstmt.setString(1, address);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			borrowerList.add(new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")));	
		}
		return borrowerList;
	}
	
	public List<Borrower> readBorrowerByPhone(String phone) throws ClassNotFoundException, SQLException{
		List<Borrower> borrowerList = new ArrayList<Borrower>();
		pstmt = getConnection().prepareStatement("Select * From tbl_borrower Where phone = ?");
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			borrowerList.add(new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")));	
		}
		return borrowerList;
	}
}
