package com.ss.sf.lms;

import java.sql.SQLException;
import java.util.List;

// Manages Client interface for librarians

import java.util.Scanner;
import com.ss.sf.lms.domain.LibraryBranch;
import com.ss.sf.lms.domain.Book;
import com.ss.sf.lms.domain.BookCopies;
import com.ss.sf.lms.dao.BookCopiesDAO;
import com.ss.sf.lms.dao.BookDAO;
import com.ss.sf.lms.dao.BranchDAO;

public class LibrarianClient {
	
	public void lib1(Scanner console) throws ClassNotFoundException, SQLException{
		System.out.println("1) Enter branch you manage\n"
				+ "2) Quit to previous menu");
		int input = console.nextInt();
		if(input == 1){
			this.lib2(console);
		}else{
			if(input == 2){
				LmsClient.mainMenu(console);
			}else{
				System.out.println("Please select the number of the category you wish to choose.\n"
						+ "1) Enter branch you manage\n"
						+ "2) Quit to previous menu");
			}
		}
	}
	
	public void lib2(Scanner console) throws ClassNotFoundException, SQLException{
		BranchDAO branchDao = new BranchDAO();
		List<LibraryBranch> branches = branchDao.readBranches();
		int count = 1;
		for(LibraryBranch branch : branches){
			System.out.println(count + ") "+ branch.getBranchName());
			count++;
		}
		System.out.println(count + ") Quit to previous menu");		
		int input = console.nextInt();
		try{
			this.lib3(branches.get(input-1), branchDao, console);
		}catch(IndexOutOfBoundsException e){
			this.lib1(console);
		}				
	}
	
	public void lib3(LibraryBranch branch, BranchDAO branchDao, Scanner console) throws ClassNotFoundException, SQLException{
		System.out.println("1) Update the details of the Library \n"
				+ "2) Add copies of Book to the Branch \n"
				+ "3) Quit to previous menu");
		int input = console.nextInt();
		if(input == 1){
			this.libUpdate(branch, branchDao, console);
		}
		if(input == 2){
			this.libAddCopies(branch, branchDao, console);
		}
		if(input == 3){
			this.lib2(console);
		}
	}
	
	public void libUpdate(LibraryBranch branch, BranchDAO branchDao, Scanner console){
		System.out.println("You have chosen to update the Branch with Branch Id: " + branch.getBranchId() + 
				" and Branch Name: " + branch.getBranchName());
		System.out.println("Enter 'quit' at any operation to cancel operation");
		System.out.println("Please enter new branch name or enter N/A for no change:");
		String input = console.next() + console.nextLine();
		if(input.equals("quit")){
			LmsClient.mainMenu(console);
		}else{
			if(input.equals("N/A")){
				//Do nothing
			}else{
				branch.setBranchName(input);
				try{
					branchDao.updateBranch(branch);
				}catch(Exception e) {
					System.out.println("An error occurred");
					e.printStackTrace();
				}
			}
		}
		System.out.println("Please enter new address or enter N/A for no change:");
		input = console.next() + console.nextLine();
		if(input.equals("quit")){
			LmsClient.mainMenu(console);
		}else{
			if(input.equals("N/A")){
				//Do nothing
			}else{
				branch.setBranchAddress(input);
				try{
					branchDao.updateBranch(branch);
				}catch(Exception e) {
					System.out.println("An error occurred");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void libAddCopies(LibraryBranch branch, BranchDAO branchDao, Scanner console){
		BookCopiesDAO bookCopiesDao = new BookCopiesDAO();
		BookDAO bookDao = new BookDAO();
		try{
			List<Book> books = bookDao.readBooks();
			int count = 1;
			for(Book book : books){
				System.out.println(count + ") " + bookDao.getBook(book.getBookId()).getTitle());
				count++;
			}
			System.out.println(count + ") Cancel operation");
			int input = console.nextInt();
			try{
				Book book = books.get(input-1);
				BookCopies bookCopy = bookCopiesDao.getBookCopy(book.getBookId(), branch.getBranchId());
				if(bookCopy == null) {
					bookCopy = new BookCopies(book.getBookId(), branch.getBranchId(), 0);
					bookCopiesDao.addBook(bookCopy);
				}
				System.out.println("Existing number of copies: " + bookCopy.getNoOfCopies());
				System.out.println("Enter new number of copies");
				input = console.nextInt();				
				bookCopy.setNoOfCopies(input);
				bookCopiesDao.updateBook(bookCopy);				
			}catch(IndexOutOfBoundsException e){
				this.lib3(branch, branchDao, console);
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
