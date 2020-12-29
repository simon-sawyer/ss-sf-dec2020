package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.BorrowerDAO;
import com.ss.sf.lms.domain.Borrower;


public class AdminBorrower {
	
	public void displayOptions(){
		System.out.println("Which operation would you like to perform:"
				+ "1) Add Borrower"
				+ "2) Update Borrower"
				+ "3) Delete Borrower"
				+ "4) Read Borrower"
				+ "5) Return to previous menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.addBorrower();
		
		}if(input == 2){
			this.updateBorrower();					
		
		}if(input == 3){
			this.deleteBorrower();
		
		}if(input == 4){
			this.readBorrower();
		
		}if(input == 5){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1();
		}
	}
	public void addBorrower(){
		Borrower newBorrower = new Borrower();
		BorrowerDAO BorrowerDao = new BorrowerDAO();
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter card number");
		newBorrower.setCardNo(console.nextInt());
		System.out.println("Please enter borrower name");
		newBorrower.setName(console.nextLine());
		System.out.println("Please enter borrower address");
		newBorrower.setAddress(console.nextLine());
		System.out.println("Please enter borrower phone");
		newBorrower.setPhone(console.nextLine());
		console.close();
		try{
			BorrowerDao.addBorrower(newBorrower);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateBorrower(){
		BorrowerDAO borrowerDao = new BorrowerDAO();
		System.out.println("Please enter the id of the Borrower that you would like to update");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Borrower borrower = borrowerDao.getBorrower(input);
			System.out.println(borrower.toString());
			
			System.out.println("Please enter card number");
			borrower.setCardNo(console.nextInt());
			System.out.println("Please enter borrower name");
			borrower.setName(console.nextLine());
			System.out.println("Please enter borrower address");
			borrower.setAddress(console.nextLine());
			System.out.println("Please enter title");
			borrower.setPhone(console.nextLine());
			console.close();
			
			borrowerDao.updateBorrower(borrower);
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteBorrower(){
		BorrowerDAO borrowerDao = new BorrowerDAO();
		System.out.println("Please enter the id of the Borrower that you would like to delete");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Borrower borrower = borrowerDao.getBorrower(input);
			System.out.println(borrower.toString());
			System.out.println("Are you sure you want to delete this borrower? /n 1) Yes /n 2) No");
			input = console.nextInt();
			console.close();
			if(input == 1){
				borrowerDao.deleteBorrower(borrower);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void readBorrower(){
		BorrowerDAO borrowerDao = new BorrowerDAO();
		try{
			System.out.println(borrowerDao.readBorrower().toString());
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
