package com.ss.sf.findChar;

// Counts the number of instances of a particular character in a file
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountChar {
	
	public static void main(String[] args){
		CountChar countMe = new CountChar();		
		char find;
		try{
			find = args[1].charAt(0);
		}catch(Exception e){
			System.out.println("Must specify character");
			Scanner input = new Scanner(System.in);
			find = input.next().charAt(0);
			input.close();
		}
		System.out.println(countMe.charCount(find, "myFile.txt"));		
	}
	
	public int charCount(char find, String path){
		// Counts all instances of find in file specified by path
		int count = 0;		
		try{
			FileReader readMe = new FileReader(path);
			int i = 0;
			while(i != -1){
				i = readMe.read();
				if(i == find){
					count++;
				}
			}
			readMe.close();
		}
		catch(IOException e){
			System.out.println("An error occurred");
			e.printStackTrace();
			return -1;
		}
		
		return count;
	}
}
