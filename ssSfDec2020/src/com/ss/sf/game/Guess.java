package com.ss.sf.game;
import java.util.Scanner;

public class Guess {
	// Creates a guessing game with 5 attempts and an error window of 10

	public static void main(String[] args) {
		
		// Generate random number 1-100
		int target = (int)(Math.random()*100) + 1;
		int guess = 0;
		int guessCount = 0;
		System.out.println("Guess a number (1-100)");
		Scanner input = new Scanner(System.in);
		while(guessCount < 5){
			guess = input.nextInt();	
			guessCount++;
			if(Math.abs(guess - target) < 10){
				System.out.println(target);
				input.close();
				break;
			}
			if(guessCount == 5){
				System.out.println("Sorry " + target);
				break;
			}
			System.out.println("Guess again");
		}
	}

}