package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.BookCopies;

public class BookCopiesDAO extends BaseDAO {

	public void addBook(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_book_copies Values (?, ?, ?)", 
				new Object[] {book.getBookId(), book.getBranchId(), book.getNoOfCopies()});
	}
	
	public void updateBook(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Update tbl_book_copies Set noOfCopies = ? Where bookId = ? AND branchId = ?", 
				new Object[] {book.getNoOfCopies(), book.getBookId(), book.getBranchId()});
	}
	
	public void deleteBranch(BookCopies book) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_book_copies Where branchId = ?",
				new Object[] {book.getBookId()});
	}
	
	public BookCopies getBookCopy(int bookId, int branchId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_book_copies Where bookId = ? AND branchId = ?");
		pstmt.setInt(1,  bookId);
		pstmt.setInt(2, branchId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new BookCopies(bookId, branchId, rs.getInt("noOfCopies"));
		}else{
			return null;
		}
	}
	
	public List<BookCopies> readBookCopies() throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book_copies");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
	
	public List<BookCopies> readBooksByBranchId(int branchId) throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book_copies Where branchId = ?");
		pstmt.setInt(1, branchId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
	
	public List<BookCopies> readBooksByNoOfCopies(int noOfCopies) throws ClassNotFoundException, SQLException{
		List<BookCopies> bookList = new ArrayList<BookCopies>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book_copies Where noOfCopies = ?");
		pstmt.setInt(1, noOfCopies);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookCopies(rs.getInt("bookId"), rs.getInt("noOfCopies"), rs.getInt("branchId")));
		}
		return bookList;
	}
}