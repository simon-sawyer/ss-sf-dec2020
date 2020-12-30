package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.AuthorDAO;
import com.ss.sf.lms.dao.BookDAO;
import com.ss.sf.lms.domain.Author;
import com.ss.sf.lms.domain.Book;

public class AdminBookAuthor {
	
	public void displayOptions(Scanner console){
		System.out.println("Which operation would you like to perform:"
				+ "1) Add Book"
				+ "2) Add Author"
				+ "3) Update Book"
				+ "4) Update Author"
				+ "5) Delete Book"
				+ "6) Delete Author"
				+ "7) Read Books"
				+ "8) Read Authors"
				+ "9) Return to previous menu");
		int input = console.nextInt();
		if(input == 1){
			this.addBook(console);
		
		}if(input == 2){
			this.addAuthor(console);					
		
		}if(input == 3){
			this.updateBook(console);
		
		}if(input == 4){
			this.updateAuthor(console);
		
		}if(input == 5){
			this.deleteBook(console);
		
		}if(input == 6){
			this.deleteAuthor(console);
		
		}if(input == 7){
			this.readBook();
		
		}if(input == 8){
			this.readAuthor();
		
		}if(input == 9){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1(console);
		}
	}
	public void addBook(Scanner console){
		Book newBook = new Book();
		BookDAO bookDao = new BookDAO();
		System.out.println("Please enter book id");
		newBook.setBookId(console.nextInt());
		System.out.println("Please enter author id");
		newBook.setAuthorId(console.nextInt());
		System.out.println("Please enter publisher id");
		newBook.setPubId(console.nextInt());
		System.out.println("Please enter title");
		newBook.setTitle(console.nextLine());
		try{
			bookDao.addBook(newBook);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void addAuthor(Scanner console){
		Author newAuthor = new Author();
		AuthorDAO authorDao = new AuthorDAO();
		System.out.println("Please enter author id");
		newAuthor.setAuthorId(console.nextInt());
		System.out.println("Please enter author name");
		newAuthor.setAuthorName(console.nextLine());
		try{
			authorDao.addAuthor(newAuthor);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateBook(Scanner console){
		BookDAO bookDao = new BookDAO();
		System.out.println("Please enter the id of the book that you would like to update");
		int input = console.nextInt();
		try{
			Book book = bookDao.getBook(input);
			System.out.println(book.toString());
			
			System.out.println("Please enter new book id");
			book.setBookId(console.nextInt());
			System.out.println("Please enter new author id");
			book.setAuthorId(console.nextInt());
			System.out.println("Please enter new publisher id");
			book.setPubId(console.nextInt());
			System.out.println("Please enter new title");
			book.setTitle(console.nextLine());
			
			bookDao.updateBook(book);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateAuthor(Scanner console){
		AuthorDAO authorDao = new AuthorDAO();
		System.out.println("Please enter the id of the author that you would like to update");
		int input = console.nextInt();
		try{
			Author author = authorDao.getAuthor(input);
			System.out.println(author.toString());
			
			System.out.println("Please enter new author id");
			author.setAuthorId(console.nextInt());
			System.out.println("Please enter new author name");
			author.setAuthorName(console.nextLine());
			
			authorDao.updateAuthor(author);			
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteBook(Scanner console){
		BookDAO bookDao = new BookDAO();
		System.out.println("Please enter the id of the book that you would like to delete");
		int input = console.nextInt();
		try{
			Book book = bookDao.getBook(input);
			System.out.println(book.toString());
			System.out.println("Are you sure you want to delete this book? /n 1) Yes /n 2) No");
			input = console.nextInt();
			if(input == 1){
				bookDao.deleteBook(book);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteAuthor(Scanner console){
		AuthorDAO authorDao = new AuthorDAO();
		System.out.println("Please enter the id of the author that you would like to delete");
		int input = console.nextInt();
		try{
			Author author = authorDao.getAuthor(input);
			System.out.println(author.toString());
			System.out.println("Are you sure you want to delete this author? /n 1) Yes /n 2) No");
			input = console.nextInt();
			if(input == 1){
				authorDao.deleteAuthor(author);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void readBook(){
		BookDAO bookDao = new BookDAO();
		try{
			System.out.println(bookDao.readBooks().toString());
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	public void readAuthor(){
		AuthorDAO authorDao = new AuthorDAO();
		try{
			System.out.println(authorDao.readAuthors().toString());
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
