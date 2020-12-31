package com.ss.sf.lms;

import java.util.Scanner;

import com.ss.sf.lms.admin.*;

public class AdministratorClient {
	
	public void admin1(Scanner console){
		System.out.println("Which of the following actions would you like to perform\n");
		System.out.println("1) Add/Update/Delete/Read Book and Author \n"
				+ "2) Add/Update/Delete/Read Publishers \n"
				+ "3) Add/Update/Delete/Read Library Branches \n"
				+ "4) Add/Update/Delete/Read Borrowers \n"
				+ "5) Over-ride Due Date for a Book Loan \n"
				+ "6) Return to main menu");
		int input = console.nextInt();
		if(input == 1){
			AdminBookAuthor admin = new AdminBookAuthor();
			admin.displayOptions(console);
		}else {
			if(input == 2){
				AdminPublishers admin = new AdminPublishers();
				admin.displayOptions(console);
			}else {
				if(input == 3){
					AdminLibraryBranch admin = new AdminLibraryBranch();
					admin.displayOptions(console);
				}else {
					if(input == 4){
						AdminBorrower admin = new AdminBorrower();
						admin.displayOptions(console);
					}else {
						if(input == 5){
							AdminBookLoans admin = new AdminBookLoans();
							admin.displayOptions(console);
						}else {
								LmsClient.mainMenu(console);;
						}
					}
				}
			}
		}
	}
}
