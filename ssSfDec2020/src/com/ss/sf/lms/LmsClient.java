package com.ss.sf.lms;

import java.util.Scanner;

// Manages Client interface for LMS

public class LmsClient {
	
	public static void main(String[] args){
		System.out.println("Welcome to the SS Library Management System. Which category of a user are you:"
				+ "/n 1) Librarian"
				+ "/n 2) Administrator"
				+ "/n 3) Borrower");
		mainMenu();
	}
	public static void mainMenu(){

		Scanner console = new Scanner(System.in);
		Integer input = console.nextInt();
		console.close();
		if(input == 1){
			LibrarianClient librarian = new LibrarianClient();
			try{
				librarian.lib1();
			}catch(Exception e){
				System.out.println("An error occurred");
				e.printStackTrace();
			}
		}else{
			if(input == 2){
				AdministratorClient admin = new AdministratorClient();
				try{
					admin.admin1();
				}catch(Exception e){
					System.out.println("An error occurred");
					e.printStackTrace();
				}
			}else{
				if(input == 3){
					BorrowerClient borrower = new BorrowerClient();
					try{
						borrower.borr1();
					}catch(Exception e){
						System.out.println("An error occurred");
						e.printStackTrace();
					}
				}else{
					System.out.println("Please select the number of the category you wish to choose."
							+ "/n 1) Librarian"
							+ "/n 2) Administrator"
							+ "/n 3) Borrower");
					mainMenu();
				}
			}			
		}		
	}

}
