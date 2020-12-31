package com.ss.sf.lms;

import java.util.Scanner;

// Manages Client interface for LMS

public class LmsClient {
	
	public static void main(String[] args){		
		Scanner console = new Scanner(System.in);
		mainMenu(console);
		console.close();
	}
	
	public static void mainMenu(Scanner console){
		System.out.println("Welcome to the SS Library Management System. Which category of user are you:\n"
				+ "\n 1) Librarian"
				+ "\n 2) Administrator"
				+ "\n 3) Borrower");
		Integer input = console.nextInt();
		if(input == 1){
			LibrarianClient librarian = new LibrarianClient();
			try{
				librarian.lib1(console);
			}catch(Exception e){
				System.out.println("An error occurred");
				e.printStackTrace();
			}
		}else{
			if(input == 2){
				AdministratorClient admin = new AdministratorClient();
				try{
					admin.admin1(console);
				}catch(Exception e){
					System.out.println("An error occurred");
					e.printStackTrace();
				}
			}else{
				if(input == 3){
					BorrowerClient borrower = new BorrowerClient();
					try{
						borrower.borr1(console);
					}catch(Exception e){
						System.out.println("An error occurred");
						e.printStackTrace();
					}
				}else{
					mainMenu(console);
				}
			}			
		}
	}

}
