package com.ss.sf.lms;

import java.util.Scanner;

import com.ss.sf.lms.admin.*;

public class AdministratorClient {
	
	public void main(String[] args){
		admin1();
	}
	
	public void admin1(){
		System.out.println("Which of the following actions would you like to perform");
		System.out.println("1) Add/Update/Delete/Read Book and Author /n"
				+ "2) Add/Update/Delete/Read Publishers /n"
				+ "3) Add/Update/Delete/Read Library Branches /n"
				+ "4) Add/Update/Delete/Read Borrowers /n"
				+ "5) Over-ride Due Date for a Book Loan /n"
				+ "6) Return to main menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			AdminBookAuthor admin = new AdminBookAuthor();
			admin.displayOptions();
		}
		if(input == 2){
			AdminPublishers admin = new AdminPublishers();
			admin.displayOptions();
		}
		if(input == 3){
			AdminLibraryBranch admin = new AdminLibraryBranch();
			admin.displayOptions();
		}
		if(input == 4){
			AdminBorrower admin = new AdminBorrower();
			admin.displayOptions();
		}
		if(input == 5){
			AdminBookLoans admin = new AdminBookLoans();
			admin.displayOptions();
		}
		if(input == 6){
			LmsClient.mainMenu();;
		}		
	}
}
