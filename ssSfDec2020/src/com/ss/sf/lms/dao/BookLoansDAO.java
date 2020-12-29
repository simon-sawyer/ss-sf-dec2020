package com.ss.sf.lms.dao;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.BookLoans;

public class BookLoansDAO extends BaseDAO {

	public void addBook(BookLoans book) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_bookLoans (bookId) Values (?)", 
				new Object[] {book.getBookId()});
	}
	
	public void updateBook(BookLoans book) throws ClassNotFoundException, SQLException{
		save("Update tbl_bookLoans branchId = ?, cardNo = ?, dateOut = ?, dueDate = ?, Where bookId = ?", 
				new Object[] {book.getBranchId(), book.getCardNo(), book.getDateOut(), book.getDueDate(), book.getBookId()});
	}
	
	public void deleteBook(BookLoans book) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_bookLoans Where branchId = ?",
				new Object[] {book.getBookId()});
	}
	
	public BookLoans getBookLoan(int bookId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans Where bookId = ?");
		pstmt.setInt(1,  bookId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"), 
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate"));
		}else{
			return null;
		}
	}
	
	public List<BookLoans> readBookLoans() throws ClassNotFoundException, SQLException{
		List<BookLoans> bookList = new ArrayList<BookLoans>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"),
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate")));
		}
		return bookList;
	}
	
	public List<BookLoans> readBooksByBranchId(int branchId) throws ClassNotFoundException, SQLException{
		List<BookLoans> bookList = new ArrayList<BookLoans>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans Where branchId = ?");
		pstmt.setInt(1, branchId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"),
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate")));
		}
		return bookList;
	}
	
	public List<BookLoans> readBooksByCardNo(int cardNo) throws ClassNotFoundException, SQLException{
		List<BookLoans> bookList = new ArrayList<BookLoans>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans Where cardNo = ?");
		pstmt.setInt(1, cardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"),
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate")));
		}
		return bookList;
	}
	
	public List<BookLoans> readBooksByDateOut(LocalDateTime dateOut) throws ClassNotFoundException, SQLException{
		List<BookLoans> bookList = new ArrayList<BookLoans>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans Where branchId = ?");
		pstmt.setObject(1, dateOut);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"),
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate")));
		}
		return bookList;
	}
	public List<BookLoans> readBooksByDueDate(LocalDateTime dueDate) throws ClassNotFoundException, SQLException{
		List<BookLoans> bookList = new ArrayList<BookLoans>();
		pstmt = getConnection().prepareStatement("Select * From tbl_bookLoans Where branchId = ?");
		pstmt.setObject(1, dueDate);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new BookLoans(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"),
					(LocalDate)rs.getObject("dateOut"), (LocalDate)rs.getObject("dueDate")));
		}
		return bookList;
	}
}