package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.BranchDAO;
import com.ss.sf.lms.domain.LibraryBranch;


public class AdminLibraryBranch {
	
	public void displayOptions(){
		System.out.println("Which operation would you like to perform:"
				+ "1) Add Branch"
				+ "2) Update Branch"
				+ "3) Delete Branch"
				+ "4) Read Branch"
				+ "5) Return to previous menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.addBranch();
		
		}if(input == 2){
			this.updateBranch();					
		
		}if(input == 3){
			this.deleteBranch();
		
		}if(input == 4){
			this.readBranch();
		
		}if(input == 5){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1();
		}
	}
	public void addBranch(){
		LibraryBranch newBranch = new LibraryBranch();
		BranchDAO BranchDao = new BranchDAO();
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter branch id");
		newBranch.setBranchId(console.nextInt());
		System.out.println("Please enter branch name");
		newBranch.setBranchName(console.nextLine());
		System.out.println("Please enter branch address");
		newBranch.setBranchAddress(console.nextLine());
		console.close();
		try{
			BranchDao.addBranch(newBranch);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updateBranch(){
		BranchDAO branchDao = new BranchDAO();
		System.out.println("Please enter the id of the Branch that you would like to update");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			LibraryBranch branch = branchDao.getBranch(input);
			System.out.println(branch.toString());
			
			System.out.println("Please enter branch id");
			branch.setBranchId(console.nextInt());
			System.out.println("Please enter branch name");
			branch.setBranchName(console.nextLine());
			System.out.println("Please enter branch address");
			branch.setBranchAddress(console.nextLine());
			console.close();
			
			branchDao.updateBranch(branch);
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deleteBranch(){
		BranchDAO branchDao = new BranchDAO();
		System.out.println("Please enter the id of the branch that you would like to delete");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			LibraryBranch branch = branchDao.getBranch(input);
			System.out.println(branch.toString());
			System.out.println("Are you sure you want to delete this branch? /n 1) Yes /n 2) No");
			input = console.nextInt();
			console.close();
			if(input == 1){
				branchDao.deleteBranch(branch);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void readBranch(){
		BranchDAO branchDao = new BranchDAO();
		try{
			System.out.println(branchDao.readBranches().toString());
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}