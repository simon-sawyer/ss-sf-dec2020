// This class prints a pattern with multiple orientations and alignments

package com.ss.sf.pattern;

public class Pattern{
	public static void main (String[] args) {
		// Print each pattern with problem numbers
		
		System.out.println("1)");
		printLeft();
		System.out.println();
		
		System.out.println("2)");
		printLeftReverse();
		System.out.println();
		
		System.out.println("3)");
		printCenter();
		System.out.println();
		
		System.out.println("4)");
		printCenterReverse();
		System.out.println();
		
	}
	
	public static void printLeft(){
		// Prints the pattern left aligned
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j <= i; j++){
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.printf("..........\n");
	}
	
	public static void printLeftReverse(){
		// Prints the pattern left aligned and upside-down
		
		System.out.printf("..........\n");
		for(int i = 3; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public static void printCenter(){
		// Prints the pattern center aligned
		
		for(int i = 0; i < 8; i += 2){
			for(int k = 4 - i/2; k >= 0; k--){
				System.out.printf(" ");
			}
			for(int j = 0; j <= i; j++){
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.printf("...........\n");
	}
	
	public static void printCenterReverse(){
		// Prints the pattern center aligned and upside-down
		
		System.out.printf("...........\n");
		for(int i = 6; i >= 0; i -= 2){
			for(int k = 4 - i/2; k >= 0; k--){
				System.out.printf(" ");
			}
			for(int j = 0; j <= i; j++){
				System.out.printf("*");
			}
			System.out.println();
		}
		
	}
	
}
