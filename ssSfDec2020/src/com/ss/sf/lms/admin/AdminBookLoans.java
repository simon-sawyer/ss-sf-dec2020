package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.BookLoansDAO;
import com.ss.sf.lms.domain.BookLoans;

public class AdminBookLoans {
	public void displayOptions(Scanner console){
		System.out.println("Please enter the id of the book that you wish to override. Enter 0 to return to previous menu");
		int input = console.nextInt();
		if(input == 0){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1(console);
		}else{
			changeDueDate(input, console);
		}
	}
	public void changeDueDate(int bookId, Scanner console){
		BookLoansDAO bookLoansDao = new BookLoansDAO();
		try{
			BookLoans bookLoan = bookLoansDao.getBookLoan(bookId);
			System.out.println(bookLoan.toString());
			System.out.println("How many days do you want to add to the due date?");
			int input = console.nextInt();
			bookLoan.setDueDate(bookLoan.getDueDate().plusDays(input));
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
