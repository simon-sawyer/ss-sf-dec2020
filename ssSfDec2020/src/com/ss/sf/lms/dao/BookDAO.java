package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.Book;

public class BookDAO extends BaseDAO {

	public void addBook(Book book) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_book Values (?, ?, ?, ?)", 
				new Object[] {book.getBookId(), book.getTitle(), book.getAuthorId(), book.getPubId()});
	}
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException{
		save("Update tbl_book Set authId = ?, pubId = ?, title = ? Where bookId = ?", 
				new Object[] {book.getAuthorId(), book.getPubId(), book.getTitle(), book.getBookId()});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_book Where bookId = ?",
				new Object[] {book.getBookId()});
	}
	
	public Book getBook(int bookId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_book Where bookId = ?");
		pstmt.setInt(1,  bookId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Book(rs.getInt("bookId"), rs.getString("title"), rs.getInt("authId"), rs.getInt("pubId"));
		}else{
			return null;
		}

	}
	
	public List<Book> readBooks() throws ClassNotFoundException, SQLException{
		List<Book> bookList = new ArrayList<Book>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new Book(rs.getInt("bookId"), rs.getString("title"), rs.getInt("authId"), rs.getInt("pubId")));
		}
		return bookList;
	}
	
	public List<Book> readBooksByTitle(String title) throws ClassNotFoundException, SQLException{
		List<Book> bookList = new ArrayList<Book>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book Where title = ?");
		pstmt.setString(1, title);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new Book(rs.getInt("bookId"), rs.getString("title"), rs.getInt("authId"), rs.getInt("pubId")));
		}
		return bookList;
	}
	
	public List<Book> readBooksByAuthor(int authorId) throws ClassNotFoundException, SQLException{
		List<Book> bookList = new ArrayList<Book>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book Where authId = ?");
		pstmt.setInt(1, authorId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new Book(rs.getInt("bookId"), rs.getString("title"), rs.getInt("authId"), rs.getInt("pubId")));
		}
		return bookList;
	}
	
	public List<Book> readBooksByPublisher(int pubId) throws ClassNotFoundException, SQLException{
		List<Book> bookList = new ArrayList<Book>();
		pstmt = getConnection().prepareStatement("Select * From tbl_book Where pubId = ?");
		pstmt.setInt(1, pubId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bookList.add(new Book(rs.getInt("bookId"), rs.getString("title"), rs.getInt("authId"), rs.getInt("pubId")));
		}
		return bookList;
	}
	
}
