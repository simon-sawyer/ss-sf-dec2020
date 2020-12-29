package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.BookCopies;

public class BookCopiesDAO extends BaseDAO {

	public void addBook(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_bookCopies (bookId) Values (?)", 
				new Object[] {book.getBookId()});
	}
	
	public void updateBook(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Update tbl_bookCopies branchId = ?, noOfCopies = ? Where bookId = ?", 
				new Object[] {book.getBranchId(), book.getNoOfCopies(), book.getBookId()});
	}
	
	public void deleteBranch(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_bookCopies Where branchId = ?",
				new Object[] {book.getBookId()});
	}
	
	public List<BookCopies> readBookCopies() throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookCopies");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
	
	public List<BookCopies> readBooksByBranchId(int branchId) throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookCopies Where branchId = ?");
		pstmt.setInt(1, branchId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
	
	public List<BookCopies> readBooksByNoOfCopies(int noOfCopies) throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookCopies Where noOfCopies = ?");
		pstmt.setInt(1, noOfCopies);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
}