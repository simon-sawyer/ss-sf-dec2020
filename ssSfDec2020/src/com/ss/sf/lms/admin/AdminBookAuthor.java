package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.AuthorDAO;
import com.ss.sf.lms.dao.BookDAO;
import com.ss.sf.lms.domain.Author;
import com.ss.sf.lms.domain.Book;

public class AdminBookAuthor {
	
	public void displayOptions(){
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
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.addBook();
		
		}if(input == 2){
			this.addAuthor();					
		
		}if(input == 3){
			this.updateBook();
		
		}if(input == 4){
			this.updateAuthor();
		
		}if(input == 5){
			this.deleteBook();
		
		}if(input == 6){
			this.deleteAuthor();
		
		}if(input == 7){
			this.readBook();
		
		}if(input == 8){
			this.readAuthor();
		
		}if(input == 9){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1();
		}
	}
	public void addBook(){
		Book newBook = new Book();
		BookDAO bookDao = new BookDAO();
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter book id");
		newBook.setBookId(console.nextInt());
		System.out.println("Please enter author id");
		newBook.setAuthorId(console.nextInt());
		System.out.println("Please enter publisher id");
		newBook.setPubId(console.nextInt());
		System.out.println("Please enter title");
		newBook.setTitle(console.nextLine());
		console.close();
		try{
			bookDao.addBook(newBook);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void addAuthor(){
		Author newAuthor = new Author();
		AuthorDAO authorDao = new AuthorDAO();
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter author id");
		newAuthor.setAuthorId(console.nextInt());
		System.out.println("Please enter author name");
		newAuthor.setAuthorName(console.nextLine());
		console.close();
		try{
			authorDao.addAuthor(newAuthor);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateBook(){
		BookDAO bookDao = new BookDAO();
		System.out.println("Please enter the id of the book that you would like to update");
		Scanner console = new Scanner(System.in);
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
			console.close();
			
			bookDao.updateBook(book);
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateAuthor(){
		AuthorDAO authorDao = new AuthorDAO();
		System.out.println("Please enter the id of the author that you would like to update");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Author author = authorDao.getAuthor(input);
			System.out.println(author.toString());
			
			System.out.println("Please enter new author id");
			author.setAuthorId(console.nextInt());
			System.out.println("Please enter new author name");
			author.setAuthorName(console.nextLine());
			console.close();
			
			authorDao.updateAuthor(author);			
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteBook(){
		BookDAO bookDao = new BookDAO();
		System.out.println("Please enter the id of the book that you would like to delete");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Book book = bookDao.getBook(input);
			System.out.println(book.toString());
			System.out.println("Are you sure you want to delete this book? /n 1) Yes /n 2) No");
			input = console.nextInt();
			console.close();
			if(input == 1){
				bookDao.deleteBook(book);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteAuthor(){
		AuthorDAO authorDao = new AuthorDAO();
		System.out.println("Please enter the id of the author that you would like to delete");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Author author = authorDao.getAuthor(input);
			System.out.println(author.toString());
			System.out.println("Are you sure you want to delete this author? /n 1) Yes /n 2) No");
			input = console.nextInt();
			console.close();
			if(input == 1){
				authorDao.deleteAuthor(author);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			console.close();
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
