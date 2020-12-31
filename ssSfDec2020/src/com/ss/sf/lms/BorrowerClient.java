package com.ss.sf.lms;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public void borr1(Scanner console){
		System.out.println("Enter your card number");
		int input = console.nextInt();
		BorrowerDAO borrowerDao = new BorrowerDAO();
		try{
			while(borrowerDao.getBorrower(input) == null){
				System.out.println("Please enter a valid card number. Enter 0 to return to main menu");
				input = console.nextInt();
				if(input == 0){
					LmsClient.mainMenu(console);
				}				
			}
			cardNo = input;
			System.out.println("1) Check out a book \n"
					+ "2) Return a Book\n"
					+ "3) Quit to Previous");
			input = console.nextInt();
			if(input == 1){
				this.checkOut(console);
			}else{
				if(input == 2){
					this.checkIn(console);
				}else{
					LmsClient.mainMenu(console);
				}
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
			
	}
	
	public void checkOut(Scanner console){
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
			int input = console.nextInt();
			try{
				this.selectBook(branches.get(input-1), true, console);
			}catch(IndexOutOfBoundsException e){
				this.borr1(console);
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	public void selectBook(LibraryBranch branch, boolean out, Scanner console){
		BookCopiesDAO bookCopiesDao = new BookCopiesDAO();
		BookDAO bookDao = new BookDAO();
		BookLoansDAO bookLoansDao = new BookLoansDAO();
		System.out.println("Please select the book that you want to " + (out? "check out": "return"));
		try{
			List<BookCopies> bookCopiesTemp = bookCopiesDao.readBooksByBranchId(branch.getBranchId());
			List<BookCopies> bookCopies = new ArrayList<BookCopies>();
			int count = 1;
			for(BookCopies bookCopy : bookCopiesTemp){
				if(bookCopy.getNoOfCopies() > 0 && out){
					System.out.println(count + ") " + bookDao.getBook(bookCopy.getBookId()));
					bookCopies.add(bookCopy);
					count++;
				}else {
					if(!out) {
						System.out.println(count + ") " + bookDao.getBook(bookCopy.getBookId()));
						bookCopies.add(bookCopy);
						count++;
					}
				}
			}
			System.out.println(count + ") Cancel operation");
			int input = console.nextInt();
			try{
				BookCopies bookCopy = bookCopies.get(input-1);
				if(out){
					BookLoans bookLoan = new BookLoans(bookCopy.getBookId(), branch.getBranchId(), cardNo, LocalDate.now(), LocalDate.now().plusDays(7));
					bookLoansDao.addBook(bookLoan);
				}else{
					if(bookLoansDao.getBookLoan(bookCopy.getBookId(), cardNo, branch.getBranchId()).getCardNo() == cardNo) {
						bookLoansDao.deleteBook(bookLoansDao.getBookLoan(bookCopy.getBookId(), cardNo, branch.getBranchId()));
						System.out.println("Book successfully returned");
					}else {
						System.out.println("You did not check out this book.");
					}
				}				
			}catch(IndexOutOfBoundsException e){
				this.borr1(console);
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void checkIn(Scanner console){
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
			int input = console.nextInt();
			try{
				this.selectBook(branches.get(input-1), false, console);
			}catch(IndexOutOfBoundsException e){
				this.borr1(console);
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
