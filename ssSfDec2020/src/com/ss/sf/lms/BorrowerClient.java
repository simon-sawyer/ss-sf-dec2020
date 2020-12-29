package com.ss.sf.lms;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ss.sf.lms.dao.BookCopiesDAO;
import com.ss.sf.lms.dao.BookDAO;
import com.ss.sf.lms.dao.BookLoansDAO;
import com.ss.sf.lms.dao.BorrowerDAO;
import com.ss.sf.lms.dao.BranchDAO;
import com.ss.sf.lms.domain.BookCopies;
import com.ss.sf.lms.domain.BookLoans;
import com.ss.sf.lms.domain.LibraryBranch;

public class BorrowerClient {
	
	private int cardNo;
	
	public void borr1(){
		System.out.println("Enter your card number");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		BorrowerDAO borrowerDao = new BorrowerDAO();
		try{
			while(borrowerDao.getBorrower(input) == null){
				System.out.println("Please enter a valid card number. Enter 0 to return to main menu");
				input = console.nextInt();
				if(input == 0){
					console.close();
					LmsClient.mainMenu();
				}				
			}
			System.out.println("1) Check out a book /n"
					+ " 2) Return a Book /n"
					+ "3) Quit to Previous");
			input = console.nextInt();
			console.close();
			if(input == 1){
				this.checkOut();
			}else{
				if(input == 2){
					this.checkIn();
				}else{
					LmsClient.mainMenu();
				}
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
			
	}
	
	public void checkOut(){
		System.out.println("Please select the branch that you want to borrow from");
		BranchDAO branchDao = new BranchDAO();
		try{
			List<LibraryBranch> branches = branchDao.readBranches();
			int count = 1;
			for(LibraryBranch branch : branches){
				System.out.println(count + ") " + branch.getBranchName());
				count++;
			}
			System.out.println(count + ") Quit to previous menu");
			Scanner console = new Scanner(System.in);
			int input = console.nextInt();
			console.close();
			try{
				this.selectBook(branches.get(input), true);
			}catch(IndexOutOfBoundsException e){
				this.borr1();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	public void selectBook(LibraryBranch branch, boolean out){
		BookCopiesDAO bookCopiesDao = new BookCopiesDAO();
		BookDAO bookDao = new BookDAO();
		BookLoansDAO bookLoansDao = new BookLoansDAO();
		System.out.println("Please select the book that you want to " + (out? "check out": "return"));
		try{
			List<BookCopies> bookCopies = bookCopiesDao.readBookCopies();
			int count = 1;
			for(BookCopies bookCopy : bookCopies){
				if(bookCopy.getNoOfCopies() > 0){
					System.out.println(count + ") " + bookDao.getBook(bookCopy.getBookId()));
					count++;
				}
			}
			System.out.println(count + ") Cancel operation");
			Scanner console = new Scanner(System.in);
			int input = console.nextInt();
			try{
				BookCopies bookCopy = bookCopies.get(input);
				if(out){
					BookLoans bookLoan = new BookLoans(bookCopy.getBookId(), bookCopy.getBranchId(), cardNo, LocalDate.now(), LocalDate.now().plusDays(7));
					bookLoansDao.updateBook(bookLoan);
				}else{
					bookLoansDao.deleteBook(bookLoansDao.getBookLoan(bookCopy.getBookId()));
				}				
			}catch(IndexOutOfBoundsException e){
				console.close();
				this.borr1();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void checkIn(){
		System.out.println("Please select the branch that you want to return to");
		BranchDAO branchDao = new BranchDAO();
		try{
			List<LibraryBranch> branches = branchDao.readBranches();
			int count = 1;
			for(LibraryBranch branch : branches){
				System.out.println(count + ") " + branch.getBranchName());
				count++;
			}
			System.out.println(count + ") Quit to previous menu");
			Scanner console = new Scanner(System.in);
			int input = console.nextInt();
			console.close();
			try{
				this.selectBook(branches.get(input), false);
			}catch(IndexOutOfBoundsException e){
				this.borr1();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
