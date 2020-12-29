package com.ss.sf.lms.admin;

import java.util.Scanner;

import com.ss.sf.lms.AdministratorClient;
import com.ss.sf.lms.dao.PublisherDAO;
import com.ss.sf.lms.domain.Publisher;


public class AdminPublishers {
	
	public void displayOptions(){
		System.out.println("Which operation would you like to perform:"
				+ "1) Add Publisher"
				+ "2) Update Publisher"
				+ "3) Delete Publisher"
				+ "4) Read Publisher"
				+ "5) Return to previous menu");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		console.close();
		if(input == 1){
			this.addPublisher();
		
		}if(input == 2){
			this.updatePublisher();					
		
		}if(input == 3){
			this.deletePublisher();
		
		}if(input == 4){
			this.readPublisher();
		
		}if(input == 5){
			AdministratorClient admin = new AdministratorClient();
			admin.admin1();
		}
	}
	public void addPublisher(){
		Publisher newPublisher = new Publisher();
		PublisherDAO PublisherDao = new PublisherDAO();
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter publisher id");
		newPublisher.setPubId(console.nextInt());
		System.out.println("Please enter publisher name");
		newPublisher.setPubName(console.nextLine());
		System.out.println("Please enter publisher address");
		newPublisher.setPubAddress(console.nextLine());
		System.out.println("Please enter publisher phone");
		newPublisher.setPubPhone(console.nextLine());
		console.close();
		try{
			PublisherDao.addPublisher(newPublisher);
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void updatePublisher(){
		PublisherDAO publisherDao = new PublisherDAO();
		System.out.println("Please enter the id of the Publisher that you would like to update");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Publisher publisher = publisherDao.getPublisher(input);
			System.out.println(publisher.toString());
			
			System.out.println("Please enter publisher id");
			publisher.setPubId(console.nextInt());
			System.out.println("Please enter publisher name");
			publisher.setPubName(console.nextLine());
			System.out.println("Please enter publisher address");
			publisher.setPubAddress(console.nextLine());
			System.out.println("Please enter publisher phone");
			publisher.setPubPhone(console.nextLine());
			console.close();
			
			publisherDao.updatePublisher(publisher);
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void deletePublisher(){
		PublisherDAO publisherDao = new PublisherDAO();
		System.out.println("Please enter the id of the publisher that you would like to delete");
		Scanner console = new Scanner(System.in);
		int input = console.nextInt();
		try{
			Publisher publisher = publisherDao.getPublisher(input);
			System.out.println(publisher.toString());
			System.out.println("Are you sure you want to delete this publisher? /n 1) Yes /n 2) No");
			input = console.nextInt();
			console.close();
			if(input == 1){
				publisherDao.deletePublisher(publisher);
			}else{
				this.displayOptions();
			}
		}catch(Exception e){
			console.close();
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	public void readPublisher(){
		PublisherDAO publisherDao = new PublisherDAO();
		try{
			System.out.println(publisherDao.readPublisher().toString());
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
