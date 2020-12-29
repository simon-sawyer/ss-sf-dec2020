package com.ss.sf.lms;

import java.sql.SQLException;
import java.util.List;

// Manages Client interface for librarians

import java.util.Scanner;
import com.ss.sf.lms.domain.LibraryBranch;
import com.ss.sf.lms.domain.BookCopies;
import com.ss.sf.lms.dao.BookCopiesDAO;
import com.ss.sf.lms.dao.BookDAO;
import com.ss.sf.lms.dao.BranchDAO;

public class LibrarianClient {
	
	public void lib1() throws ClassNotFoundException, SQLException{
		System.out.println("1) Enter branch you manage "
				+ "/n 2) Quit to previous menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.lib2();
		}else{
			if(input == 2){
				LmsClient.mainMenu();
			}else{
				System.out.println("Please select the number of the category you wish to choose."
						+ "1) Enter branch you manage "
						+ "/n 2) Quit to previous menu");
			}
		}
	}
	
	public void lib2() throws ClassNotFoundException, SQLException{
		BranchDAO branchDao = new BranchDAO();
		List<LibraryBranch> branches = branchDao.readBranches();
		int count = 1;
		for(LibraryBranch branch : branches){
			System.out.println(count + ") "+ branch.getBranchName());
			count++;
		}
		System.out.println(count + ") Quit to previous menu");		
		
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		try{
			this.lib3(branches.get(input), branchDao);
		}catch(IndexOutOfBoundsException e){
			this.lib1();
		}				
	}
	
	public void lib3(LibraryBranch branch, BranchDAO branchDao) throws ClassNotFoundException, SQLException{
		System.out.println("1) Update the details of the Library /n"
				+ "2) Add copies of Book to the Branch /n"
				+ "3) Quit to previous menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.libUpdate(branch, branchDao);
		}
		if(input == 2){
			this.libAddCopies(branch, branchDao);
		}
		if(input == 3){
			this.lib2();
		}
	}
	
	public void libUpdate(LibraryBranch branch, BranchDAO branchDao){
		System.out.println("You have chosen to update the Branch with Branch Id: " + branch.getBranchId() + 
				" and Branch Name: " + branch.getBranchName());
		System.out.println("Enter 'quit' at any operation to cancel operation");
		System.out.println("Please enter new branch name or enter N/A for no change:");
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		if(input.equals("quit")){
			console.close();
			LmsClient.mainMenu();
		}else{
			if(input.equals("N/A")){
				//Do nothing
			}else{
				branch.setBranchName(input);
			}
		}
		System.out.println("Please enter new address or enter N/A for no change:");
		input = console.nextLine();
		if(input.equals("quit")){
			console.close();
			LmsClient.mainMenu();
		}else{
			if(input.equals("N/A")){
				//Do nothing
			}else{
				branch.setBranchAddress(input);
			}
		}
	}
	
	public void libAddCopies(LibraryBranch branch, BranchDAO branchDao){
		BookCopiesDAO bookCopiesDao = new BookCopiesDAO();
		BookDAO bookDao = new BookDAO();
		try{
			List<BookCopies> bookCopies = bookCopiesDao.readBooksByBranchId(branch.getBranchId());
			int count = 1;
			for(BookCopies bookCopy : bookCopies){
				System.out.println(count + ") " + bookDao.getBook(bookCopy.getBookId()).getTitle());
				count++;
			}
			System.out.println(count + ") Cancel operation");
			Scanner console = new Scanner(System.in);
			int input = console.nextInt();
			try{
				BookCopies bookCopy = bookCopies.get(input);
				System.out.println("Existing number of copies: " + bookCopy.getNoOfCopies());
				System.out.println("Enter new number of copies");
				input = console.nextInt();
				console.close();
				bookCopy.setNoOfCopies(input);
				bookCopiesDao.updateBook(bookCopy);				
			}catch(IndexOutOfBoundsException e){
				console.close();
				this.lib3(branch, branchDao);
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
